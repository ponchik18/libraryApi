package com.bovkun.libraryApi.controller;

import com.bovkun.libraryApi.dto.BookDTO;
import com.bovkun.libraryApi.service.impl.DefaultBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final DefaultBookService bookService;

    @GetMapping
    public List<BookDTO> findAllBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public BookDTO findBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/isbn/{isbn}")
    public BookDTO findBookByIsbn(@PathVariable String isbn) {
        return bookService.getBookByISBN(isbn);
    }

    @PostMapping("/add")
    public BookDTO saveBook(@RequestBody BookDTO book) {
        return bookService.saveBook(book);
    }

    @PostMapping("/update")
    public BookDTO updateBook(@RequestBody BookDTO book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public BookDTO deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }
}