package com.exam.service.impl;

import com.exam.model.Contract;
import com.exam.repository.ContractRepository;
import com.exam.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;
    @Override
    public List<Contract> selectAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract create(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id);
    }

    @Override
    public void delete(Contract contract) {
        contractRepository.delete(contract);
    }
}
