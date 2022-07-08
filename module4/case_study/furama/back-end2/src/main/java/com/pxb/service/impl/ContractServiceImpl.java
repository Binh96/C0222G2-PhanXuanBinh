package com.pxb.service.impl;

import com.pxb.model.Contract;
import com.pxb.repository.ContractRepository;
import com.pxb.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Override
    public Page<Contract> selectAll(Pageable pageable) {
        return contractRepository.selectAll(pageable);
    }

    @Override
    public void create(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void edit(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id);
    }

    @Override
    public Page<Contract> selectByCustomerId(Pageable pageable, int id) {
        return contractRepository.selectByCustomerId(pageable, id);
    }

    @Override
    public void deleteById(int id) {
        contractRepository.deleteById(id);
    }
}
