package com.bovkun.libraryApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booksRegistry")
public class BookRegistry {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Book book;
    private LocalDate borrowedAt;
    private LocalDate returnBy;

    @PrePersist
    public void prePersist() {
        if (borrowedAt == null) {
            borrowedAt = LocalDate.now();
        }
        if (returnBy == null) {
            returnBy = borrowedAt.plusDays(5);
        }
    }

}