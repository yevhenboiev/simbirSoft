package com.simbirsoft.testwork.helper;

import com.simbirsoft.testwork.exeption.StorageException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class SplitHelper {

    private static Logger logger = LogManager.getLogger(SplitHelper.class.getName());



    public static List<String> splitAndSortText(String text) {
        logger.warn("Not found text in Site");
        Optional.ofNullable(text).orElseThrow(() -> {
            throw new StorageException("Not found text in Site", null);
        });
        return Arrays.stream(text.toUpperCase().split("[ ,.—\\-'!?\";:\\[\\]/()\\n\\r\\t]+")).toList().stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
