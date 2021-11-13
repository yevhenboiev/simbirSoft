package com.simbirsoft.testwork.storage;

import com.simbirsoft.testwork.util.SqlHelper;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;

public class ParserRepository {

    private final SqlHelper sqlHelper;

    public ParserRepository(String dbUrl, String dbUser, String dbPassword) {
        sqlHelper = new SqlHelper(() -> DriverManager.getConnection(dbUrl, dbUser, dbPassword));
    }

    public void save(Map<String, Integer> storage, String url) {
        sqlHelper.transactionExecute(conn -> {
            try (PreparedStatement preparedStatement =
                         conn.prepareStatement("INSERT INTO webSite (url) VALUES (?)")) {
                preparedStatement.setString(1, url);
                preparedStatement.execute();
            }
            try (PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO wordsCounter (site_url, word, count) VALUES (?, ?, ?)"
            )) {
                for (Map.Entry<String, Integer> item : storage.entrySet()) {
                    preparedStatement.setString(1, url);
                    preparedStatement.setString(2, item.getKey());
                    preparedStatement.setInt(3, item.getValue());
                    preparedStatement.addBatch();
                }
                preparedStatement.executeBatch();
            }
            return null;
        });
    }

}
