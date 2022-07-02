package com.repository;

import com.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value="select * from book", nativeQuery = true)
    List<Book> selectAll();

    @Query(value="select * from book", nativeQuery = true)
    Page<Book> selectAllPage(Pageable pageable);

    @Query(value="select id from book", nativeQuery = true)
    List<Integer> selectAllId();

    @Query(value =" select * from book where id = :id", nativeQuery = true)
    Book selectById(int id);

    @Modifying
    @Transactional
    @Query(value = " update book set so_luong = so_luong - 1 where id = :id " , nativeQuery = true)
    void borrowBook(@Param("id") int id);

    @Query(value = " select luu_tru from book where id = :id", nativeQuery = true)
    int selectStorage(@Param("id") int id);
}
