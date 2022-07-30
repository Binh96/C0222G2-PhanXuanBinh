package com.pxb.backendexam.service.impl;

import com.pxb.backendexam.model.Consignment;
import com.pxb.backendexam.repository.ConsignmentRepository;
import com.pxb.backendexam.service.ConsignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsignmentServiceImpl implements ConsignmentService {
    @Autowired
    private ConsignmentRepository consignmentRepository;

    @Override
    public List<Consignment> getAll() {
        return consignmentRepository.findAll();
    }

    @Override
    public Consignment findById(int id) {
        return consignmentRepository.findById(id);
    }

    @Override
    public List<Consignment> findByAll(String name) {
        return consignmentRepository.findByName('%'+ name + '%');
    }

    @Override
    public Consignment createConsignment(Consignment consignment) {
        return consignmentRepository.save(consignment);
    }

    @Override
    public Consignment editConsignment(Consignment consignment) {
        return consignmentRepository.save(consignment);
    }

    @Override
    public Integer deleteConsignment(int id) {
        return consignmentRepository.delete(id);
    }
}
