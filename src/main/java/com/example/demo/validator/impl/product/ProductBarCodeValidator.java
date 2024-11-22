package com.example.demo.validator.impl.product;

import com.example.demo.model.Product;
import com.example.demo.validator.Validator;
import org.springframework.stereotype.Component;

@Component
public class ProductBarCodeValidator implements Validator {

    @Override
    public void validate(Object object) {
        Product product = (Product) object;
        if(!product.getCodeBarre().startsWith("619")) {
            throw new RuntimeException("Not Tunisian product");
        }
    }

    @Override
    public boolean accept(Object object) {
        return object instanceof Product;
    }
}
