package com.example.crud.model;

import com.example.crud.enums.Genre;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String writerName;
    private Long yearPublished;
    private String publisher;

    @Enumerated(EnumType.STRING)
    private Genre genre;
}
