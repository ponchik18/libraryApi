package com.bovkun.libraryApi.repository;

import com.bovkun.libraryApi.entity.BookRegistry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRegistryRepository extends JpaRepository<BookRegistry, Long> {
}
