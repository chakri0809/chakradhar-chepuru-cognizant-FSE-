package com.cognizant.borrow.controller;
import com.cognizant.borrow.entity.BorrowRecord;
import com.cognizant.borrow.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;
@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    private BorrowRepository borrowRepository;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping
    public List<BorrowRecord> getAllRecords() {
        return borrowRepository.findAll();
    }
    @PostMapping
    public String borrowBook(@RequestBody BorrowRecord record) {
        Object book=restTemplate.getForObject("http://book-service/books/"+record.getBookId(),Object.class);
        if(book==null) {
            return "Book not found, cannot borrow!";
        }
        borrowRepository.save(record);
        return "Book borrowed successfully!";
    }
}
