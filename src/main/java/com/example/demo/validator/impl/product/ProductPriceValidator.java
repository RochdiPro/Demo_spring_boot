package com.example.demo.validator.impl.product;

import com.example.demo.model.Product;
import com.example.demo.validator.Validator;
import org.springframework.stereotype.Component;

@Component
public class ProductPriceValidator implements Validator {

    @Override
    public void validate(Object object) {
        Product product = (Product) object;
        if(product.getPrice() > 100) {
            throw new RuntimeException("price > 100");
        }
    }

    @Override
    public boolean accept(Object object) {
        return object instanceof Product;
    }
}
