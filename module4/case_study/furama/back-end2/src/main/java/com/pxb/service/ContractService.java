package com.pxb.service;

import com.pxb.dto.ContractDto;
import com.pxb.model.Contract;
import com.pxb.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
    Page<Contract> selectAll(Pageable pageable);

    Contract create(Contract contract);
    void edit(Contract contract);

    Contract findById(int id);

    Page<Contract> selectByCustomerId(Pageable pageable, int id);

    void deleteById(int id);

    Page<ContractDto> getTotal(Pageable pageable);

}
