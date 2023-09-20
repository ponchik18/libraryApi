package com.bovkun.libraryApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
            returnBy = borrowedAt.plus(5, ChronoUnit.DAYS);
        }
    }

}
