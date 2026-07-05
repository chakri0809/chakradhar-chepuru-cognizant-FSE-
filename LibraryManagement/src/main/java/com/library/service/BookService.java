package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Exercise 6: @Service annotation for annotation-based configuration
@Service
public class BookService {

    private BookRepository bookRepository;

    // Exercise 1: default no-arg constructor (used by XML bean definition)
    public BookService() {
    }

    // Exercise 7: Constructor Injection
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Exercise 2 & 7: Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title) {
        bookRepository.save(title);
    }

    public String getBook(int id) {
        return bookRepository.findBookById(id);
    }
}
