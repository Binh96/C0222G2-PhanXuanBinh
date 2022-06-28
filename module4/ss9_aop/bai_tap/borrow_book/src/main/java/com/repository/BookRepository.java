package com.repository;

import com.model.Book;
import com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value="select * from book", nativeQuery = true)
    List<Book> selectAll();

    @Query(value="select id from book", nativeQuery = true)
    List<Integer> selectAllId();

    @Query(value ="select * from book where id = :id", nativeQuery = true)
    Book selectById(int id);

}
