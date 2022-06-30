package com.service;

import com.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    List<Book> selectAll();

    Book selectById(int id);

    void update(Book book);

    List<Integer> selectAllId();

    Page<Book> selectAllPage(Pageable pageable);

    boolean checkBookBorrow(Book book);

    boolean checkBookPayBack(Book book);

    void bookBorrow(int id);
}
