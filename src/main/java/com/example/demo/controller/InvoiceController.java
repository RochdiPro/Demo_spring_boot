package com.example.demo.controller;

import com.example.demo.model.Invoice;
import com.example.demo.service.InvoiceService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Invoice")
@SecurityRequirement(name = "Bearer")
@Tag(name = "Invoice  endpoint", description = " all endpoint of Invoice ")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Invoice>> Invoice() {
        return ResponseEntity.ok(invoiceService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Invoice> getInvoice(@PathVariable Long id) {
        return ResponseEntity.ok(invoiceService.getById(id).orElse(null));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Invoice> addInvoice(@RequestBody Invoice invoice) {
        return ResponseEntity.ok(invoiceService.add(invoice));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        invoiceService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Invoice> updatInvoice(@RequestBody Invoice invoice) {
        return ResponseEntity.ok(invoiceService.update(invoice));

    }
}