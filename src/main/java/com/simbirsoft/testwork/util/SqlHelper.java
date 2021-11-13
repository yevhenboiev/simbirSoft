package com.simbirsoft.testwork.util;

import com.simbirsoft.testwork.exception.StorageException;

import java.sql.Connection;
import java.sql.SQLException;

public class SqlHelper {

    public ConnectionFactory connectionFactory;

    public SqlHelper(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }


    public <T> void transactionExecute(SqlExecutor<T> executor) {
        try (Connection conn = connectionFactory.getConnection()) {
            try {
                conn.setAutoCommit(false);
                executor.execute(conn);
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw ExceptionConverter.convert(e);
            }
        } catch (SQLException e) {
            throw new StorageException(e.getMessage());
        }
    }
}
