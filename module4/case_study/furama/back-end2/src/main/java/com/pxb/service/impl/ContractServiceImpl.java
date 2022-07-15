package com.pxb.service.impl;

import com.pxb.dto.ContractDto;
import com.pxb.model.Contract;
import com.pxb.repository.ContractRepository;
import com.pxb.service.ContractService;
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
    public Page<Contract> selectAll(Pageable pageable) {
        return contractRepository.selectAll(pageable);
    }

    @Override
    public Contract create(Contract contract) {
        return contractRepository.save(contract);
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

    @Override
    public Page<ContractDto> getTotal(Pageable pageable) {
        return contractRepository.getTotal(pageable);
    }


}
