package com.simbirsoft.testwork.storage;

import java.util.HashMap;
import java.util.Map;

public class MapStorage implements Storage {

    private final Map<String, Integer> storage = new HashMap<>();

    public void save(String word, int count) {
        storage.put(word, count);
    }

    public Map<String, Integer> getAllWordsAndCount() {
        return storage;
    }

    public void printAllWords() {
        for (Map.Entry<String, Integer> item : storage.entrySet()) {
            System.out.printf("%s : %s\n", item.getKey(), item.getValue());
        }
    }

    public int size() {
        return storage.size();
    }
}
