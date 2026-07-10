package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class LibraryManagementApplication {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\n--- Testing Setter Injection (bookService) ---");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.addBook("Effective Java");
        System.out.println(bookService.getBook(1));

        System.out.println("\n--- Testing Constructor Injection (bookServiceConstructor) ---");
        BookService constructorService =
                context.getBean("bookServiceConstructor", BookService.class);
        constructorService.addBook("Spring in Action");
        System.out.println(constructorService.getBook(2));
    }
}
