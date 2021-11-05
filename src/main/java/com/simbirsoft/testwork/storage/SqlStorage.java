package com.simbirsoft.testwork.storage;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.simbirsoft.testwork.util.SqlHelper;

public class SqlStorage implements Storage {

    private final SqlHelper sqlHelper;

    public SqlStorage(String dbUrl, String dbUser, String dbPassword) {
        sqlHelper = new SqlHelper(() -> DriverManager.getConnection(dbUrl, dbUser, dbPassword));
    }

    @Override
    public void save(String word, int count) {
        sqlHelper.execute("INSERT INTO wordsInSite (word, count) VALUES (?, ?)", ps -> {
            ps.setString(1, word);
            ps.setInt(2, count);
            ps.execute();
            return null;
        });
    }

    @Override
    public Map<String, Integer> getAllWordsAndCount() {
        return sqlHelper.execute("SELECT * FROM wordsInSite", ps -> {
            ResultSet rs = ps.executeQuery();
            Map<String, Integer> words = new HashMap<>();
            while(rs.next()) {
                String word = rs.getString("word");
                int count = rs.getInt("count");
                words.put(word, count);
            }
            return words;
        });
    }

    @Override
    public void printAllWords() {
        for (Map.Entry<String, Integer> item : getAllWordsAndCount().entrySet()) {
            System.out.printf("%s : %s\n", item.getKey(), item.getValue());
        }
    }

    @Override
    public int size() {
        return sqlHelper.execute("SELECT COUNT(*) FROM wordsInSite", ps -> {
            ResultSet rs = ps.executeQuery();
            return rs.next() ? rs.getInt(1) : 0;
        });
    }
}
