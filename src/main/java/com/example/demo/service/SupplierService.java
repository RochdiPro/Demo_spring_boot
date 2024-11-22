package com.example.demo.service;

import com.example.demo.model.Supplier;
import com.example.demo.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class SupplierService implements DefaultService<Supplier, Long> {

    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public JpaRepository<Supplier, Long> getRepository() {
        return  this.supplierRepository;
    }
}


