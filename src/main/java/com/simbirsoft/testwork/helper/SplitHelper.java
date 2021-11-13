package com.simbirsoft.testwork.helper;

import com.simbirsoft.testwork.exception.StorageException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SplitHelper {

    private static final String WORDS_DELIMITER = "[ ,.—\\-'!?\";:\\[\\]/()\\n\\r\\t]+";
    private static final Logger LOG = LogManager.getLogger(SplitHelper.class.getName());

    public static List<String> splitAndSortText(String text) {
        if (text == null) {
            LOG.info("Not found text in Site");
            throw new StorageException("Not found text in Site");
        }
        return Pattern.compile(WORDS_DELIMITER).splitAsStream(text.toUpperCase())
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
