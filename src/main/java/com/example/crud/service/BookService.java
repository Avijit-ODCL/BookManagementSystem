package com.example.crud.service;

import com.example.crud.model.Book;
import com.example.crud.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook (Book book){
        return bookRepository.save(book);
    }

    public List<Book> getAllBook (){
        return bookRepository.findAll();
    }

    public Optional<Book> getBook (Long id){
        return bookRepository.findById(id);
    }

    public String deleteBook(Long id){
        if (bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return "Book deleted. Id: "+id;
        }else {
            return "Book Not Found";
        }
    }
}
