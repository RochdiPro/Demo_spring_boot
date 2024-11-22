package com.example.demo.validator;

import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test {

    @Autowired
    private ProductValidator productValidator;
    public void test() {
        Product p = new Product();
        p.setPrice(90);
        p.setCodeBarre("61929332323");
        productValidator.validateProduct(p);

    }
}
