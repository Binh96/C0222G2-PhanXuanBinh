package com.service.impl;

import com.model.Book;
import com.repository.BookRepository;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Book> selectAllPage(Pageable pageable) {
        return bookRepository.selectAllPage(pageable);
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

    @Override
    public void bookBorrow(int id) {
        bookRepository.borrowBook(id);
    }

    @Override
    public boolean checkStorage(Book book) {
        return book.getStorage() == bookRepository.selectStorage(book.getId());
    }
}
