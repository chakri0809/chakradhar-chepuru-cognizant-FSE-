package com.cognizant.book;
import com.cognizant.book.entity.Book;
import com.cognizant.book.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class BookServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner initData(BookRepository repository) {
        return args -> {
            repository.save(new Book("The Hobbit", "J.R.R. Tolkien"));
            repository.save(new Book("1984", "George Orwell"));
        };
    }
}
