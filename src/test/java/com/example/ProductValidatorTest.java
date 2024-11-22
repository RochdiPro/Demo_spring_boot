package com.example;

import com.example.demo.model.Product;
import com.example.demo.validator.ProductValidator;
import com.example.demo.validator.Validator;
import com.example.demo.validator.impl.product.ProductBarCodeValidator;
import com.example.demo.validator.impl.product.ProductPriceValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductValidatorTest {




    private Validator productPriceValidator = new ProductPriceValidator();



    private Validator productBarCodeValidator = new ProductBarCodeValidator();


    private List<Validator> validators = List.of(productPriceValidator, productBarCodeValidator);

    @InjectMocks
    private ProductValidator productValidator;


    @Test
    void test() {
        ReflectionTestUtils.setField(productValidator, "validators", validators);
        Product product = Mockito.mock(Product.class);
        Mockito.when(product.getPrice()).thenReturn(90d);
        Mockito.when(product.getCodeBarre()).thenReturn("619sdfsdf");
        Assertions.assertDoesNotThrow(() -> productValidator.validateProduct(product));
    }

}
