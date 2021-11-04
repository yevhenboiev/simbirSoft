package com.simbirsoft.testwork.util;

import com.simbirsoft.testwork.exeption.NotFoundUrl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupParser {
    private String url;

    public JsoupParser(String url) {
        this.url = url;
    }

    public String read() {
        try {
            Document webSite = Jsoup.connect(url).get();
            return webSite.text();
        } catch (IOException e) {
            throw new NotFoundUrl(url);
        }
    }
}
