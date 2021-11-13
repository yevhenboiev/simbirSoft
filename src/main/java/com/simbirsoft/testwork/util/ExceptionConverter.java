package com.simbirsoft.testwork.util;

import com.simbirsoft.testwork.exception.StorageException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class ExceptionConverter {

    private static final Logger LOG = LogManager.getLogger(ExceptionConverter.class.getName());

    public static StorageException convert(SQLException e) {
        LOG.info(e.getSQLState());
        if (e.getSQLState().equals("23505")) {
            return new StorageException("Exist DataBase", e);
        } else if (e.getSQLState().equals("22023")) {
            return new StorageException("Not exist DataBase", e);
        }
        return new StorageException(e.getMessage(), e);
    }

}
