package com.bovkun.libraryApi.controller;

import com.bovkun.libraryApi.dto.BookDTO;
import com.bovkun.libraryApi.dto.BookRegistryDTO;
import com.bovkun.libraryApi.service.impl.DefaultLibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library")
public class BookRegistryController {

    private final DefaultLibraryService libraryService;

    @GetMapping("/free")
    public List<BookDTO> findAllFreeBook() {
        return libraryService.getAllFreeBook();
    }

    @GetMapping
    public List<BookRegistryDTO> findAllBookRegistry() {
        return libraryService.getAllBookRegistry();
    }

    @PostMapping("/add")
    public BookRegistryDTO saveBookRegistry(@RequestBody Long bookId) {
        return libraryService.addBookRegistry(bookId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBookRegistry(@PathVariable Long id) {
        return libraryService.deleteBookRegistry(id);
    }

    @GetMapping("/{id}")
    public BookRegistryDTO findByIdBookRegistry(@PathVariable Long id) {
        return libraryService.getBookRegistryById(id);
    }

}