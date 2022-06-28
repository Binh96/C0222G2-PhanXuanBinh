package com.service;

import com.model.Book;
import com.model.User;

import java.util.List;

public interface UserService{
    void create(User  user);
    boolean selectByCodeBorrow(int codeBorrow, Book book);

}
