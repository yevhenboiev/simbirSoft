package com.simbirsoft.testwork.config;

import com.simbirsoft.testwork.storage.ParserRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SqlConfig {

    private static final File PROPS = new File("src/main/resources/sql.properties");
    private static final SqlConfig INSTANCE = new SqlConfig();

    private final ParserRepository parserRepository;

    private SqlConfig() {
        try (InputStream is = new FileInputStream(PROPS)) {
            Properties props = new Properties();
            props.load(is);
            parserRepository = new ParserRepository(props.getProperty("db.url"),
                    props.getProperty("db.user"),
                    props.getProperty("db.password"));
        } catch (IOException e) {
            throw new IllegalStateException("Invalid config file " + PROPS.getAbsolutePath(), e);
        }
    }

    public static SqlConfig get() {
        return INSTANCE;
    }

    public ParserRepository getStorage() {
        return parserRepository;
    }

}
