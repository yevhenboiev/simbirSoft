package com.simbirsoft.testwork.storage;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.simbirsoft.testwork.exeption.StorageException;
import com.simbirsoft.testwork.util.SqlHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataBase {

    private final SqlHelper sqlHelper;
    private static Logger logger = LogManager.getLogger(DataBase.class.getName());
    private String url;

    public DataBase(String dbUrl, String dbUser, String dbPassword) {
        sqlHelper = new SqlHelper(() -> DriverManager.getConnection(dbUrl, dbUser, dbPassword));
    }

    public void createTable(String url) {
        this.url = url;
        sqlHelper.execute("CREATE TABLE IF NOT EXISTS \"" + url + "\"\n" +
                "(\n" +
                "    id SERIAL,\n" +
                "    word VARCHAR(100),\n" +
                "    count INTEGER,\n" +
                "    PRIMARY KEY(id)\n" +
                ");");
    }

    public void doSave(Map<String, Integer> storage, String url) {
        sqlHelper.execute("DELETE FROM \"" + url + "\"");
        for (Map.Entry<String, Integer> item : storage.entrySet()) {
            sqlHelper.execute("INSERT INTO \"" + url + "\" (word, count) VALUES (?, ?)", ps -> {
                ps.setString(1, item.getKey());
                ps.setInt(2, item.getValue());
                ps.execute();
                return null;
            });
        }
    }

}
