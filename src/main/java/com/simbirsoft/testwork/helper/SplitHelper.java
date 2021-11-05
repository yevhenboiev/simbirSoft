package com.simbirsoft.testwork.helper;

import com.simbirsoft.testwork.exeption.EmptyTextInSite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class SplitHelper {

    private static Logger logger = LogManager.getLogger(SplitHelper.class.getName());

    public static String[] splitAndSortText(String text) {
        logger.warn("Not found text in Site");
        Optional.ofNullable(text).orElseThrow(() -> {
            throw new EmptyTextInSite("Not found text in Site", null);
        });
        String[] textInSite = text.split("[ ,.—'!?\";:\\[\\]()\\-\\n\\r\\t]+");
        Arrays.sort(textInSite);
        return textInSite;
    }
}
