package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
@SecurityRequirement(name = "Bearer")
@Tag(name = "Product endpoint", description = " all endpoint of product ")

public class ProductController {
    @Autowired
    ProductService produitService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> produit() {
        return ResponseEntity.ok(produitService.findAll());
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProduit(@PathVariable Long id) {
        return ResponseEntity.ok( produitService.getById(id).orElse(null));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> addProduit(@RequestBody Product produit) {
        return ResponseEntity.ok( produitService.add(produit));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        produitService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduit(@RequestBody Product produit) {
        return ResponseEntity.ok(produitService.update( produit));

    }
}
