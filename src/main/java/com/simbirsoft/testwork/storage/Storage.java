package com.simbirsoft.testwork.storage;

import java.util.Map;

public interface Storage {

    void save(String word, int count);

    Map<String, Integer> getAllWordsAndCount();

    void printAllWords();

    int size();
}
