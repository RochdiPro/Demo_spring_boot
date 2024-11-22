package com.example.demo.validator.impl.user;

import com.example.demo.model.User;
import com.example.demo.validator.Validator;
import org.springframework.stereotype.Component;

@Component
public class UserAdminRoleValidator implements Validator {
    @Override
    public void validate(Object object) {
        User user = (User) object;
        if(!user.getRole().equals("admin")) {
            throw new RuntimeException("User is not admin");
        }
    }

    @Override
    public boolean accept(Object object) {
        return object instanceof User;
    }
}
