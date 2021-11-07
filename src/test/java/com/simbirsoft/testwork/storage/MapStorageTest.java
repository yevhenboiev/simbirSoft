package com.simbirsoft.testwork.storage;

import com.simbirsoft.testwork.exeption.StorageException;
import com.simbirsoft.testwork.helper.SplitHelper;
import com.simbirsoft.testwork.util.JsoupParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapStorageTest {

  String url = "testedURL";
  MapStorage mapStorage = new MapStorage();
  Map<String, Integer> expectedMap = new HashMap<>();
  String expectedLine = "Hello, my, hello. friend";
  List<String> wordsInText = SplitHelper.splitAndSortText(expectedLine);

  @BeforeEach
  public void setUp() {
    mapStorage.clear();
    mapStorage.save(wordsInText, url);
  }


  @Test
  void save() {
    List<String> wordsInText = SplitHelper.splitAndSortText(expectedLine);
    expectedMap.put("HELLO", 2);
    expectedMap.put("MY", 1);
    expectedMap.put("FRIEND", 1);
    mapStorage.save(wordsInText, url);
    assertEquals(expectedMap, mapStorage.getStorage());
  }

  @Test
  void size() {
    expectedMap.put("HELLO", 2);
    expectedMap.put("MY", 1);
    expectedMap.put("FRIEND", 1);
    assertEquals(expectedMap.size(), mapStorage.size());
  }

  @Test
  void clear() {
    mapStorage.clear();
    assertEquals(0, mapStorage.size());
  }

  @Test
  void notFoundText() {
    assertThrows(StorageException.class, () -> {
      String line = null;
      List<String> wordsInText = SplitHelper.splitAndSortText(line);
    }, "Not found text in Site");
  }

  @Test
  void incorrectUrl() {
   assertThrows(StorageException.class, () -> {
     JsoupParser jp = new JsoupParser(url);
   }, "Incorrect url " + url);
  }


  //Send link on picture
  @Test
  void notFoundTextInSite() {
    assertThrows(StorageException.class, () -> {
      JsoupParser jp = new JsoupParser("https://www.simbirsoft.com/local/templates/.default/img" +
              "/top_bg/header_images/banner_bg2_1199plus.webp");
      jp.readDocument();
      jp.readText();
    }, "Not found text" + url);

  }
}