package com.simbirsoft.testwork.model;

import com.simbirsoft.testwork.config.SqlConfig;
import com.simbirsoft.testwork.helper.CountingHelper;
import com.simbirsoft.testwork.helper.SplitHelper;
import com.simbirsoft.testwork.storage.MapStorage;
import com.simbirsoft.testwork.storage.SqlStorage;
import com.simbirsoft.testwork.util.JsoupParser;

import java.util.Arrays;

public class Program {
    private String url;

    public Program(String url) {
        this.url = url;
    }

    public void startProgram() {
        JsoupParser webSite = new JsoupParser(url);
        String[] wordsInText = SplitHelper.splitAndSortText(webSite.read());
        System.out.println((Arrays.toString(wordsInText)));
        SqlStorage storage = new SqlStorage("jdbc:postgresql://localhost:5432/words",
                "postgres",
                "zipzone12345");
        CountingHelper.countingWords(storage, wordsInText);
        storage.printAllWords();
    }
}
