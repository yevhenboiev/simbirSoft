package com.simbirsoft.testwork.util;

import com.simbirsoft.testwork.exeption.NotFoundUrl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupParser {

    private static Logger logger = LogManager.getLogger(JsoupParser.class);
    private String url;

    public JsoupParser(String url) {
        this.url = url;
    }

    public String read() {
        try {
            Document webSite = Jsoup.connect(url).get();
            return webSite.text();
        } catch (IOException e) {
            logger.info("Not found url {}", url);
            throw new NotFoundUrl(url);
        }
    }
}
