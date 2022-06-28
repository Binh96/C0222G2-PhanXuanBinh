package com.service.impl;

import com.model.Book;
import com.repository.BookRepository;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {


    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> selectAll() {
        return bookRepository.selectAll();
    }

    @Override
    public Book selectById(int id) {
        return bookRepository.selectById(id);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Integer> selectAllId() {
        return bookRepository.selectAllId();
    }

    @Override
    public boolean checkBookBorrow(Book book) {
        if(selectById(book.getId()).getQuantity() < 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean checkBookPayBack(Book book) {
        if(selectById(book.getId()).getQuantity() == 5){
            return false;
        }
        return true;
    }
}
