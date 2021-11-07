package com.simbirsoft.testwork.storage;

import com.simbirsoft.testwork.helper.SplitHelper;
import com.simbirsoft.testwork.util.JsoupParser;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapStorageTest {

  String url = "https://jsoup.org/";
  JsoupParser htmlParser = new JsoupParser(url);
  MapStorage mapStorage = new MapStorage();
  String expectedLine = "Hello, my, hello. friend";

  @Test
  void saveExpectedLine() {
    Map<String, Integer> expectedMap = new HashMap<>();
    expectedMap.put("HELLO", 2);
    expectedMap.put("MY", 1);
    expectedMap.put("FRIEND", 1);
    assertEquals(expectedMap, mapStorage.getAllWordsAndCount());
  }

  @Test
  void getAllWordsAndCount() {
  }

  @Test
  void printAllWords() {
  }

  @Test
  void size() {
  }
}