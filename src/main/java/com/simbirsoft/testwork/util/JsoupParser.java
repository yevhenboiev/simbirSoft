package com.simbirsoft.testwork.util;

import com.simbirsoft.testwork.exception.StorageException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupParser {

    private static final Logger LOG = LogManager.getLogger(JsoupParser.class.getName());
    private final String url;
    private final Connection connection;
    private Document webSite;

    public JsoupParser(String url) {
        this.url = url;
        try {
            connection = Jsoup.connect(url);
        } catch (IllegalArgumentException e) {
            LOG.info("Incorrect url");
            throw new StorageException("Incorrect url {}", e);
        }
    }

    public void readDocument() {
        try {
            webSite = connection.get();
        } catch (IOException e) {
            LOG.info("Not found text");
            throw new StorageException("Not found text " + url, e);
        }
    }

    public String readText() {
        return webSite.body().text();
    }
}
