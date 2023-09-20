package com.bovkun.libraryApi.convert;

import com.bovkun.libraryApi.dto.BookDTO;
import com.bovkun.libraryApi.dto.BookRegistryDTO;
import com.bovkun.libraryApi.entity.Book;
import com.bovkun.libraryApi.entity.BookRegistry;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookRegistryDTOConverter {
    @Autowired
    private ModelMapper modelMapper;

    public BookRegistryDTO convertBookRegistryToBookRegistryDTO(BookRegistry bookRegistry) {
        return modelMapper.map(bookRegistry, BookRegistryDTO.class);
    }

    public BookRegistry convertBookRegistryDTOToBookRegistry(BookRegistryDTO bookRegistryDTO) {
        return modelMapper.map(bookRegistryDTO, BookRegistry.class);
    }

    public List<BookRegistryDTO> convertListOfBookRegistryToListOfBookRegistryDTO(List<BookRegistry> bookRegistries) {
        return bookRegistries.stream()
                .map(bookRegistry -> modelMapper.map(bookRegistry, BookRegistryDTO.class))
                .collect(Collectors.toList());
    }
}