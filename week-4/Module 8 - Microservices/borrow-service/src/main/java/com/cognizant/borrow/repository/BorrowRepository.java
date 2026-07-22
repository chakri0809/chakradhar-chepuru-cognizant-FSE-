package com.cognizant.borrow.repository;
import com.cognizant.borrow.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BorrowRepository extends JpaRepository<BorrowRecord, Long> {
}
