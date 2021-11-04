package com.simbirsoft.testwork.model;

import com.simbirsoft.testwork.helper.CountingHelper;
import com.simbirsoft.testwork.helper.SplitHelper;
import com.simbirsoft.testwork.storage.MapStorage;
import com.simbirsoft.testwork.util.JsoupParser;

public class Program {
    private String url;

    public Program(String url) {
        this.url = url;
    }

    public void startProgram() {
        JsoupParser webSite = new JsoupParser(url);
        String[] wordsInText = SplitHelper.splitAndSortText(webSite.read());
        MapStorage storage = new MapStorage();
        CountingHelper.countingWords(storage, wordsInText);
        storage.printAllWords();
    }
}
