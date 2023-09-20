package com.bovkun.libraryApi.convert;

import com.bovkun.libraryApi.dto.BookDTO;
import com.bovkun.libraryApi.dto.BookRegistryDTO;
import com.bovkun.libraryApi.entity.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookDTOConverter {
    @Autowired
    private ModelMapper modelMapper;

    public BookDTO convertBookToBookDTO(Book book) {
        return modelMapper.map(book, BookDTO.class);
    }

    public Book convertBookDTOToBook(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, Book.class);
    }

    public List<BookDTO> convertListOfBookToListOfBookDTO(List<Book> books) {
        return books.stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }
}