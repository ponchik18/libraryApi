package com.bovkun.libraryApi.convert;

import com.bovkun.libraryApi.dto.BookDTO;
import com.bovkun.libraryApi.entity.Book;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookDTOConverter {
    private final ModelMapper modelMapper;

    public BookDTO convertBookToBookDTO(Book book) {
        return modelMapper.map(book, BookDTO.class);
    }

    public Book convertBookDTOToBook(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, Book.class);
    }

    public List<BookDTO> convertListOfBookToListOfBookDTO(List<Book> books) {
        return books.stream().map(book -> modelMapper.map(book, BookDTO.class)).collect(Collectors.toList());
    }
}