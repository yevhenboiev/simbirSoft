package com.simbirsoft.testwork.helper;

import com.simbirsoft.testwork.exeption.StorageException;
import com.simbirsoft.testwork.storage.Storage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class CountingHelper {

    private static Logger logger = LogManager.getLogger(CountingHelper.class.getName());

    public static void countingWords(Storage storage, String[] words) {
        logger.warn("Storage is not initialized");
        Optional.ofNullable(storage).orElseThrow(() -> {
            throw new StorageException("Storage is not initialized", storage, null);
        });
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
