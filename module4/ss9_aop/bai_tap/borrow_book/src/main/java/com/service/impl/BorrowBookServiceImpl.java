package com.service.impl;

import com.model.BorrowBook;
import com.repository.BorrowBookRepository;
import com.service.BorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowBookServiceImpl implements BorrowBookService {
    @Autowired
    private BorrowBookRepository bookRepository;
    @Override
    public BorrowBook findByCodeOfBorrow(int codeOfBorrow) {
        return bookRepository.findByCodeOfBorrow(codeOfBorrow);
    }

    @Override
    public boolean checkBorrowCode(BorrowBook borrowBook) {
        List<BorrowBook> borrowBooks = bookRepository.findAll();
        for(int i=0; i< borrowBooks.size(); i++){
            if(borrowBook.getCodeOfBorrow() == borrowBooks.get(i).getCodeOfBorrow()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void createBorrowBook(BorrowBook borrowBook) {
        if(!checkBorrowCode(borrowBook)){
            bookRepository.save(borrowBook);
        }
    }
}
