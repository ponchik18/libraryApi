package com.bovkun.libraryApi.util;

import com.bovkun.libraryApi.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.Objects;
import java.util.Optional;

public class RestPreconditions {
    public static <T> T checkFound(T resource) {
        if(Objects.isNull(resource)) {
            throw new ResourceNotFoundException();
        } else {
            return resource;
        }
    }
}
