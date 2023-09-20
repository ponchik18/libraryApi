package com.bovkun.libraryApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String title;
    private String isbn;
    private String genre;
    private String description;
    private String author;
    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    private Set<BookRegistry> bookRegistries;
}
