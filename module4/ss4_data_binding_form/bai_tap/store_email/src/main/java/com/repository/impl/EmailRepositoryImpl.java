package com.repository.impl;

import com.model.Email;
import com.repository.EmailRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailRepositoryImpl implements EmailRepository {
    List<Email> emailList = new ArrayList<>();

    @Override
    public void save(Email email) {
        emailList.add(email);
    }

    @Override
    public List<Email> selectAll() {
        return emailList;
    }
}
