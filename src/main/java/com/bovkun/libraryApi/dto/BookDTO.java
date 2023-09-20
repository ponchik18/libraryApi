package com.bovkun.libraryApi.dto;

import lombok.Data;

@Data
public class BookDTO {
    private Long id;
    private String title;
    private String isbn;
    private String genre;
    private String description;
    private String author;
}
