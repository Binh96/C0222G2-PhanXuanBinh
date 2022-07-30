package com.pxb.backendexam.service;

import com.pxb.backendexam.model.Consignment;

import java.util.List;

public interface ConsignmentService {

    List<Consignment> getAll();

    Consignment findById(int id);

    List<Consignment> findByAll(int id);

    Consignment createConsignment(Consignment consignment);

    Consignment editConsignment(Consignment consignment);

    Integer deleteConsignment(int id);
}
