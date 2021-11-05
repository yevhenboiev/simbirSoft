package com.simbirsoft.testwork.exeption;

import com.simbirsoft.testwork.storage.Storage;

public class StorageException extends RuntimeException {

    private final String url;
    private Storage storage;


    public StorageException(String message, String url) {
        super(message);
        this.url = url;
    }

    public StorageException(String message, Storage storage, String url) {
        this(message, url);
        this.storage = storage;
    }

    public String getUrl() {
        return url;
    }

    public Storage getStorage() {
        return storage;
    }
}
