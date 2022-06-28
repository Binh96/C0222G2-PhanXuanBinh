package com.service;

import com.model.Book;
import com.model.User;

import java.util.List;

public interface BookService {
    List<Book> selectAll();

    Book selectById(int id);

    void update(Book book);

    List<Integer> selectAllId();

    boolean checkBookBorrow(Book book);

    boolean checkBookPayBack(Book book);
}
