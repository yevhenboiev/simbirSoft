package com.simbirsoft.testwork.exeption;

public class StorageException extends RuntimeException {

    private final String url;


    public StorageException(String message, String url) {
        super(message);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
