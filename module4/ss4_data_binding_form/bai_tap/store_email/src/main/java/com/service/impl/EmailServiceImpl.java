package com.service.impl;

import com.model.Email;
import com.repository.EmailRepository;
import com.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Override
    public void save(Email email) {
        emailRepository.save(email);
    }

    @Override
    public List<Email> selectAll() {
        return emailRepository.selectAll();
    }
}
