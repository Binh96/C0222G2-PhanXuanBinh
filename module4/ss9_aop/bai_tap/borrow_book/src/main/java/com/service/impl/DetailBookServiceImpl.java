package com.service.impl;

import com.model.DetailBook;
import com.repository.DetailRepository;
import com.service.DetailBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailBookServiceImpl implements DetailBookService {

    @Autowired
    private DetailRepository detailRepository;

    @Override
    public void create(DetailBook detailBookList) {
        detailRepository.save(detailBookList);
    }

    @Override
    public List<DetailBook> selectAll() {
        return detailRepository.selectAll();
    }

    @Override
    public boolean checkIdDetailBook(int id) {
        List<DetailBook> detailBooks = detailRepository.selectAll();
        for(int i=0; i< detailBooks.size(); i++){
            if(detailBooks.get(i).getCodeOfBook() == id){
                return true;
            }
        }
        return false;
    }

    @Override
    public DetailBook findById(int id) {
        return detailRepository.selectById(id);
    }

    @Override
    public Page<DetailBook> selectAllPage(Pageable pageable) {
        return detailRepository.selectAllPage(pageable);
    }

    @Override
    public void updateDetailBook(DetailBook detailBookList) {
        detailRepository.save(detailBookList);
    }
}
