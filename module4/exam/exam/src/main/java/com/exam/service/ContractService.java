package com.exam.service;

import com.exam.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ContractService {

    List<Contract> selectAll();

    Contract create(Contract contract);

    Contract findById(int id);

    void delete(Contract contract);
}
