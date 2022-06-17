package com.repository;

import com.model.Email;

import java.util.List;

public interface EmailRepository {
    void save(Email email);
    List<Email> selectAll();
}
