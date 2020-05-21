package com.jongmin.springcore.validator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private String firstName;
    private String surname;
    private Address address;
}
