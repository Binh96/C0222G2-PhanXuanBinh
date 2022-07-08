package com.pxb.service;

import com.pxb.model.Contract;
import com.pxb.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    Page<Contract> selectAll(Pageable pageable);

    void create(Contract contract);
    void edit(Contract contract);

    Contract findById(int id);

    Page<Contract> selectByCustomerId(Pageable pageable, int id);

    void deleteById(int id);
}
