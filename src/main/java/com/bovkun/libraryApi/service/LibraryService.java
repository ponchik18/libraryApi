package com.bovkun.libraryApi.service;

import com.bovkun.libraryApi.dto.BookDTO;
import com.bovkun.libraryApi.dto.BookRegistryDTO;

import java.util.List;

public interface LibraryService {
    BookRegistryDTO addBookRegistry(Long bookId);
    List<BookRegistryDTO> getAllBookRegistry();
    BookRegistryDTO getBookRegistryById(Long bookRegistryId);
    String deleteBookRegistry(Long bookRegistryId);
    List<BookDTO> getAllFreeBook();
}
