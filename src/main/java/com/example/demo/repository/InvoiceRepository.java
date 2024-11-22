package com.example.demo.repository;

import com.example.demo.model.Client;
import com.example.demo.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findInvoicesByCreatedDate(Date date);

    List<Invoice> findInvoicesByCreatedDateAndTotalGreaterThan(Date date,double total);

    List<Invoice> findInvoicesByClientAndTotalGreaterThan(Client client, double total);

}
