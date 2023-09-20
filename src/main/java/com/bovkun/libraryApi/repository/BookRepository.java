package com.bovkun.libraryApi.repository;

import com.bovkun.libraryApi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository  extends JpaRepository<Book, Long> {
    Book findByIsbn(String isbn);
    List<Book> findByBookRegistriesIsNull();
}
