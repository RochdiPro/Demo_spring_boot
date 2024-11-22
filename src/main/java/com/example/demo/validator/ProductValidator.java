package com.example.demo.validator;

import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class ProductValidator {

    @Autowired
    private List<Validator> validators;

    public void validateProduct(Product product) {
        validators.stream()
                .filter(validator -> validator.accept(product))
                .forEach(validator -> validator.validate(product));
    }

}
