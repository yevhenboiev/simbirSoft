package com.simbirsoft.testwork.exeption;

import com.simbirsoft.testwork.storage.Storage;

public class EmptyTextInSite extends StorageException {

    public EmptyTextInSite(String message, Storage url) {
        super(message, url, null);
    }
}
