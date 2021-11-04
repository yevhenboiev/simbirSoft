package com.simbirsoft.testwork.helper;

import com.simbirsoft.testwork.storage.Storage;

import java.util.Objects;

public class CountingHelper {

    public static void countingWords(Storage storage, String[] words) {
        Objects.requireNonNull(storage, "Not found you storage");
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            String word = words[i];
            count += 1;
            if (!words[i].equals(words[i + 1])) {
                storage.save(word.toUpperCase(), count);
                count = 0;
            }
        }
    }
}
