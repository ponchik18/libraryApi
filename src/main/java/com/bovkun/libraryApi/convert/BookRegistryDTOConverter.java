package com.bovkun.libraryApi.convert;

import com.bovkun.libraryApi.dto.BookRegistryDTO;
import com.bovkun.libraryApi.entity.BookRegistry;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookRegistryDTOConverter {

    private final ModelMapper modelMapper;

    public BookRegistryDTO convertBookRegistryToBookRegistryDTO(BookRegistry bookRegistry) {
        return modelMapper.map(bookRegistry, BookRegistryDTO.class);
    }

    public List<BookRegistryDTO> convertListOfBookRegistryToListOfBookRegistryDTO(List<BookRegistry> bookRegistries) {
        return bookRegistries.stream().map(bookRegistry -> modelMapper.map(bookRegistry, BookRegistryDTO.class)).collect(Collectors.toList());
    }
}