package com.bovkun.libraryApi.controller;

import com.bovkun.libraryApi.dto.BookDTO;
import com.bovkun.libraryApi.service.impl.DefaultBookService;
import com.bovkun.libraryApi.util.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private DefaultBookService bookService;

    @Autowired
    public void setBookService(DefaultBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDTO> findAllBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public BookDTO findBookById(@PathVariable Long id) {
        return RestPreconditions.checkFound(bookService.getBookById(id));
    }

    @GetMapping("/isbn/{isbn}")
    public BookDTO findBookByIsbn(@PathVariable String isbn) {
        return RestPreconditions.checkFound(bookService.getBookByISBN(isbn));
    }

    @PostMapping("/add")
    public BookDTO saveBook(@RequestBody BookDTO book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/update")
    public BookDTO updateBook(@RequestBody BookDTO book) {
        return RestPreconditions.checkFound(bookService.updateBook(book));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }




}
