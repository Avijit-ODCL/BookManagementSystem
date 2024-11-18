package com.example.crud.controller;

import com.example.crud.model.Book;
import com.example.crud.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
public class BookController {
    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook (Book book){
        return ok(bookService.addBook(book));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBook (){
        return ok(bookService.getAllBook());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> getBook (@PathVariable Long id){
        return ok(bookService.getBook(id));
    }
}
