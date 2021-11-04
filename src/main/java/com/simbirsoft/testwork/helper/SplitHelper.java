package com.simbirsoft.testwork.helper;

import java.util.Arrays;
import java.util.Objects;

public class SplitHelper {

    public static String[] splitAndSortText(String text) {
        Objects.requireNonNull(text, "Not found words in site");
        String[] textInSite = text.split("[ ,.—'!?\";:\\[\\]()\\-\\n\\r\\t]+");
        Arrays.sort(textInSite);
        return textInSite;
    }
}
