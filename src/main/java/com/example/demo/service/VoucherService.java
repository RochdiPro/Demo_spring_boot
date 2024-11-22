package com.example.demo.service;

import com.example.demo.model.Voucher;
import com.example.demo.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class VoucherService implements DefaultService<Voucher, Long> {

    @Autowired
    VoucherRepository voucherRepositoryy;

    @Override
    public JpaRepository<Voucher, Long> getRepository() {
        return this.voucherRepositoryy;
    }
}
