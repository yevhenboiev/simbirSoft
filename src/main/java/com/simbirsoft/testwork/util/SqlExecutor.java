package com.simbirsoft.testwork.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SqlExecutor<T> {
    T execute(Connection conn) throws SQLException;
}
