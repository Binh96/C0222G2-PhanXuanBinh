package com.service;

import com.model.Email;

import java.util.List;

public interface EmailService {
    void save(Email email);
    List<Email> selectAll();
}
