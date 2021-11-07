package com.simbirsoft.testwork.storage;

import com.simbirsoft.testwork.helper.SplitHelper;
import com.simbirsoft.testwork.util.JsoupParser;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapStorageTest {

  String url = "https://jsoup.org/";
  JsoupParser htmlParser = new JsoupParser(url);
  MapStorage mapStorage = new MapStorage();
  String expectedLine = "Hello, my, hello. friend";
  Map<String, Integer> expectedMap = new HashMap<>();

  @Test
  void save() {
    List<String> wordsInText = SplitHelper.splitAndSortText(expectedLine);
    expectedMap.put("HELLO",2);
    expectedMap.put("MY",1);
    expectedMap.put("FRIEND",1);
    mapStorage.save(wordsInText, url);
    assertEquals(expectedMap, mapStorage.getStorage());
  }

  @Test
  void size() {
    assertEquals(expectedMap.size(), mapStorage.size());
  }
}