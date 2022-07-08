package com.pxb.service;

import com.pxb.model.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> selectAll();

    List<ContractDetail> selectById(int id);

    ContractDetail saveContractDetail(ContractDetail contractDetail);
}
