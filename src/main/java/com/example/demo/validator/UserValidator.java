package com.example.demo.validator;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
public class UserValidator {
    @Autowired
    private List<Validator> validators;

    public void validateUser(User user) {
        validators.stream()
                .filter(validator -> validator.accept(user))
                .forEach(validator -> validator.validate(user));
    }
}
