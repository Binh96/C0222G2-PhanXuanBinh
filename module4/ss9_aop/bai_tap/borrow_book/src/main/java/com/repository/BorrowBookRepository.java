package com.repository;

import com.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowBookRepository extends JpaRepository<BorrowBook, Integer> {
    @Query(value = "select * from sach_da_muon where codeOfBorrow = :codeOfBorrow", nativeQuery = true)
    BorrowBook findByCodeOfBorrow(int codeOfBorrow);
}
