package com.example;


import com.example.demo.model.Product;
import com.example.demo.validator.impl.product.ProductPriceValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ValidatorTest {

    private ProductPriceValidator productPriceValidator = new ProductPriceValidator();

    @Test
    void testProductPriceValidatorTest() {
        Product product = Mockito.mock(Product.class);
        Mockito.when(product.getPrice()).thenReturn(90d);
        boolean accept = productPriceValidator.accept(product);
        Assertions.assertTrue(accept);
        Assertions.assertDoesNotThrow(() -> productPriceValidator.validate(product));
    }

    @Test
    void testProductPriceValidatorTest2() {
        Product product = Mockito.mock(Product.class);
        Mockito.when(product.getPrice()).thenReturn(120d);
        boolean accept = productPriceValidator.accept(product);
        Assertions.assertTrue(accept);
        Assertions.assertThrows(RuntimeException.class, () -> productPriceValidator.validate(product));
    }

}
