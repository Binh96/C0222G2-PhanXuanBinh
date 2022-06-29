package com.service;

import com.model.DetailBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DetailBookService {
    void create(DetailBook detailBookList);
    List<DetailBook> selectAll();

    boolean checkIdDetailBook(int id);

    Page<DetailBook> selectAllPage(Pageable pageable);
}
