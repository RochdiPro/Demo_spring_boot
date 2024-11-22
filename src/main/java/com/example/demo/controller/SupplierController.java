package com.example.demo.controller;

import com.example.demo.model.Supplier;
import com.example.demo.service.SupplierService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/supplier")
@SecurityRequirement(name = "Bearer")
@Tag(name = "Supplier  endpoint", description = " all endpoint of Supplier ")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Supplier>> Supplier() {
        return ResponseEntity.ok(supplierService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Supplier> getSupplier(@PathVariable Long id) {
        return ResponseEntity.ok(supplierService.getById(id).orElse(null));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(supplierService.add(supplier));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Supplier> updatSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(supplierService.update(supplier));

    }
}