package com.service;

import com.model.BorrowBook;

public interface BorrowBookService {
    BorrowBook findByCodeOfBorrow(int codeOfBorrow);

    boolean checkBorrowCode(BorrowBook borrowBook);

    void createBorrowBook(BorrowBook borrowBook);

}
