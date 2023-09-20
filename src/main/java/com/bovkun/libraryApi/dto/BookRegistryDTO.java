package com.bovkun.libraryApi.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookRegistryDTO {
    private Long id;
    private BookDTO book;
    private LocalDate borrowedAt;
    private LocalDate returnBy;
}
