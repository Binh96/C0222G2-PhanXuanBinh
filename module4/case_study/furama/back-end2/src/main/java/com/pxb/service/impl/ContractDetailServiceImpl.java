package com.pxb.service.impl;

import com.pxb.model.ContractDetail;
import com.pxb.repository.ContractDetailRepository;
import com.pxb.repository.ContractRepository;
import com.pxb.service.ContractDetailService;
import com.pxb.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;
    @Override
    public List<ContractDetail> selectAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public List<ContractDetail> selectById(int id) {
        return contractDetailRepository.selectById(id);
    }

    @Override
    public ContractDetail saveContractDetail(ContractDetail contractDetail) {
        return contractDetailRepository.save(contractDetail);
    }
}
