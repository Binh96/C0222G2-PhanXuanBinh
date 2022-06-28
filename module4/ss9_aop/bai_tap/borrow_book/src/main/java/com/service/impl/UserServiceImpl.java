package com.service.impl;

import com.model.Book;
import com.model.User;
import com.repository.UserRepository;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean selectByCodeBorrow(int codeBorrow, Book book) {
        User user = userRepository.selectByCodeBorrow(codeBorrow);
        return user.getBook().getId() == book.getId();
    }

}
