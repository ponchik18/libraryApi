package com.bovkun.libraryApi.service.impl;

import com.bovkun.libraryApi.convert.BookDTOConverter;
import com.bovkun.libraryApi.convert.BookRegistryDTOConverter;
import com.bovkun.libraryApi.dto.BookDTO;
import com.bovkun.libraryApi.dto.BookRegistryDTO;
import com.bovkun.libraryApi.entity.Book;
import com.bovkun.libraryApi.entity.BookRegistry;
import com.bovkun.libraryApi.exception.ResourceNotFoundException;
import com.bovkun.libraryApi.repository.BookRegistryRepository;
import com.bovkun.libraryApi.repository.BookRepository;
import com.bovkun.libraryApi.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DefaultLibraryService implements LibraryService {

    private final DefaultBookService bookService;

    private final BookRegistryRepository bookRegistryRepository;

    private final BookRegistryDTOConverter bookRegistryDTOConverter;


    private final BookDTOConverter bookDTOConverter;


    private final BookRepository bookRepository;

    @Override
    public BookRegistryDTO addBookRegistry(Long bookId) {
        BookRegistry bookRegistry = new BookRegistry();
        Book addedBook = bookDTOConverter.convertBookDTOToBook(bookService.getBookById(bookId));
        if (Objects.isNull(addedBook)) {
            return null;
        }
        bookRegistry.setBook(addedBook);
        bookRegistryRepository.save(bookRegistry);

        return bookRegistryDTOConverter.convertBookRegistryToBookRegistryDTO(bookRegistry);
    }

    @Override
    public List<BookRegistryDTO> getAllBookRegistry() {
        return bookRegistryDTOConverter.convertListOfBookRegistryToListOfBookRegistryDTO(bookRegistryRepository.findAll());
    }

    @Override
    public BookRegistryDTO getBookRegistryById(Long bookRegistryId) {
        return bookRegistryDTOConverter.convertBookRegistryToBookRegistryDTO(bookRegistryRepository.findById(bookRegistryId).orElseThrow(() -> new ResourceNotFoundException(bookRegistryId)));
    }

    @Override
    public String deleteBookRegistry(Long bookRegistryId) {
        bookRegistryRepository.deleteById(bookRegistryId);
        return "bookRegistry removed with id = " + bookRegistryId;
    }

    @Override
    public List<BookDTO> getAllFreeBook() {
        return bookDTOConverter.convertListOfBookToListOfBookDTO(bookRepository.findByBookRegistriesIsNull());
    }


}