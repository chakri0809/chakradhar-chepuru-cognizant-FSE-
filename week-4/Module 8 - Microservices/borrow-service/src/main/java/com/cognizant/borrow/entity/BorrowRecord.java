package com.cognizant.borrow.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long bookId;
    private String borrowerName;
    public BorrowRecord() {}
    public BorrowRecord(Long bookId, String borrowerName) {
        this.bookId=bookId;
        this.borrowerName=borrowerName;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id=id;
    }
    public Long getBookId() {
        return bookId;
    }
    public void setBookId(Long bookId) {
        this.bookId=bookId;
    }
    public String getBorrowerName() {
        return borrowerName;
    }
    public void setBorrowerName(String borrowerName) {
        this.borrowerName=borrowerName;
    }
}
