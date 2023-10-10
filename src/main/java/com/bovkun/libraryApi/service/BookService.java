package com.bovkun.libraryApi.service;

import com.bovkun.libraryApi.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getBooks();
    BookDTO getBookById(Long id);
    BookDTO getBookByISBN(String isbn);
    BookDTO saveBook(BookDTO bookDTO);
    BookDTO deleteBook(Long id);
    BookDTO updateBook(BookDTO bookDTO);

}