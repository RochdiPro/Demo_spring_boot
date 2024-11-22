package com.example.demo.service;

import com.example.demo.model.Invoice;
import com.example.demo.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService  implements DefaultService<Invoice, Long> {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public JpaRepository<Invoice, Long> getRepository() {
        return this.invoiceRepository;
    }
}

