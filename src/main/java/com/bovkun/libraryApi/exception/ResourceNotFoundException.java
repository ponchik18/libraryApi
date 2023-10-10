package com.bovkun.libraryApi.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {
    private final Object objectException;

    public ResourceNotFoundException(Object objectException) {
        this.objectException = objectException;
    }

}