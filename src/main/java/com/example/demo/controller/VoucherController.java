package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.model.Voucher;
import com.example.demo.service.ClientService;
import com.example.demo.service.VoucherService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/voucher")
@SecurityRequirement(name = "Bearer")
@Tag(name = "Voucher  endpoint", description = " all endpoint of Voucher ")
public class VoucherController {
    @Autowired
    VoucherService voucherService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Voucher>> Voucher() {
        return ResponseEntity.ok(voucherService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Voucher> getVoucher(@PathVariable Long id) {
        return ResponseEntity.ok(voucherService.getById(id).orElse(null));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Voucher> addVoucher(@RequestBody Voucher voucher) {
        return ResponseEntity.ok(voucherService.add(voucher));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteVoucher(@PathVariable Long id) {
        voucherService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Voucher> updatVoucher(@RequestBody Voucher voucher) {
        return ResponseEntity.ok(voucherService.update(voucher));

    }
}