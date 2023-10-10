package com.bovkun.libraryApi.service.impl;

import com.bovkun.libraryApi.convert.BookDTOConverter;
import com.bovkun.libraryApi.dto.BookDTO;
import com.bovkun.libraryApi.entity.Book;
import com.bovkun.libraryApi.exception.ResourceNotFoundException;
import com.bovkun.libraryApi.repository.BookRepository;
import com.bovkun.libraryApi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DefaultBookService implements BookService {
    private final BookRepository bookRepository;

    private final BookDTOConverter bookDTOConverter;

    @Override
    public List<BookDTO> getBooks() {
        return bookDTOConverter.convertListOfBookToListOfBookDTO(bookRepository.findAll());
    }

    @Override
    public BookDTO getBookById(Long id) {
        return bookDTOConverter.convertBookToBookDTO(bookRepository.findById(id).orElse(null));
    }

    @Override
    public BookDTO getBookByISBN(String isbn) {
        return bookDTOConverter.convertBookToBookDTO(bookRepository.findByIsbn(isbn).orElseThrow(() -> new ResourceNotFoundException(isbn)));
    }

    @Override
    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = bookDTOConverter.convertBookDTOToBook(bookDTO);
        return bookDTOConverter.convertBookToBookDTO(bookRepository.save(book));
    }

    @Override
    public BookDTO deleteBook(Long id) {
        BookDTO bookDTO = bookDTOConverter.convertBookToBookDTO(bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id)));
        bookRepository.deleteById(id);
        return bookDTO;
    }

    @Override
    public BookDTO updateBook(BookDTO bookDTO) {
        Book book = bookDTOConverter.convertBookDTOToBook(bookDTO);
        Book existingBook = bookRepository.findById(book.getId()).orElseThrow(() -> new ResourceNotFoundException(book.getId()));
        if (Objects.isNull(existingBook)) {
            return null;
        }
        existingBook.setAuthor(book.getAuthor());
        existingBook.setDescription(book.getDescription());
        existingBook.setGenre(book.getGenre());
        existingBook.setIsbn(book.getIsbn());
        return bookDTOConverter.convertBookToBookDTO(bookRepository.save(existingBook));
    }
}