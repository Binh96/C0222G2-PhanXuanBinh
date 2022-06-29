package com.repository;

import com.model.DetailBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailRepository extends JpaRepository<DetailBook, Integer> {
    @Query(value = "select * from detail_book", nativeQuery = true)
    List<DetailBook> selectAll();

    @Query(value = "select * from detail_book", nativeQuery = true)
    Page<DetailBook> selectAllPage(Pageable pageable);
}
