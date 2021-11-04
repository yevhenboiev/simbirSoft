package com.simbirsoft.testwork.exeption;

public class NotFoundUrl extends StorageException {

    public NotFoundUrl(String url) {
        super(url + " incorrect, please send new URL", url);
    }
}
