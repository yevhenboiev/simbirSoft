package com.simbirsoft.testwork.storage;

import java.util.List;
import java.util.Map;

public interface Storage {

    void save(List<String> listWords, String url);

    Map<String, Integer> getAll();

    int size();

    void clear();
}
