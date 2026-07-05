package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public void save(String bookTitle) {
        System.out.println("BookRepository: Saving book -> " + bookTitle);
    }

    public String findBookById(int id) {
        System.out.println("BookRepository: Fetching book with id " + id);
        return "Book #" + id + " - The Spring Framework Guide";
    }
}
