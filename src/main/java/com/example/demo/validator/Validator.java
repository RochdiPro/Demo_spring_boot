package com.example.demo.validator;


public interface Validator {

    void validate(Object object);

    boolean accept(Object object);

}
