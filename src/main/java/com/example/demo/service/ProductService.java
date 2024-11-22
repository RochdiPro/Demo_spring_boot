package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements DefaultService<Product, Long> {

    @Autowired
    ProductRepository productRepository;

    public Product getByCodeBarre(String code) {
        return productRepository.findByCodeBarre(code);
    }
    public Product getByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public JpaRepository<Product, Long> getRepository() {
        return this.productRepository;
    }
}
