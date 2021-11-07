package com.simbirsoft.testwork.util;

import com.simbirsoft.testwork.exeption.StorageException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupParser {

    private static final Logger logger = LogManager.getLogger(JsoupParser.class.getName());
    private final String url;
    private final Connection connection;
    private Document webSite;

    public JsoupParser(String url) {
        this.url = url;
        connection = Jsoup.connect(url);
    }

    public Document readDocument() {
        try {
            return webSite = connection.get();
        } catch (Exception e) {
            logger.info("Not found url {}", url);
            throw new StorageException("Not found url " + url, url);
        }
    }

    public String readText() {
        return webSite.text();
    }

    public String readTitle() {
        return webSite.title();
    }

    public String readTag(String tag) {
        Elements elements = webSite.select(tag);
        return elements.text();
    }

    public String getUrl() {
        return url;
    }
}
