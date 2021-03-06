package com.simbirsoft;

import com.simbirsoft.testwork.helper.SplitHelper;
import com.simbirsoft.testwork.storage.MapStorage;
import com.simbirsoft.testwork.util.JsoupParser;

import java.util.List;

public class ProgramHtmlParse {
    public static void main(String[] args) {
        ProgramHtmlParse programHtmlParse = new ProgramHtmlParse();
        programHtmlParse.start(args[0]);
    }

    public void start(String url) {
        JsoupParser webSite = new JsoupParser(url);
        webSite.readDocument();
        List<String> wordsInText = SplitHelper.splitAndSortText(webSite.readText());
        MapStorage storage = new MapStorage();
        storage.save(wordsInText, url);
        storage.printAllWords();
    }
}
