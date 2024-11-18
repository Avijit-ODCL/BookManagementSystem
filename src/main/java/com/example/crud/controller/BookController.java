package com.example.crud.controller;

import com.example.crud.model.Book;
import com.example.crud.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Book> addBook (@RequestBody Book book){
        return ok(bookService.addBook(book));
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Book>> getAllBook (){
        return ok(bookService.getAllBook());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Book>> getBook (@PathVariable Long id){
        return ok(bookService.getBook(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Book> updateBook (@RequestBody Book book){
        Book updatedBook = bookService.updateBook(book);
        if (updatedBook != null) return ok(updatedBook);
        else return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
