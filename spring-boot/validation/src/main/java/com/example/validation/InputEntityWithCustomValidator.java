package com.example.validation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
public class InputEntityWithCustomValidator {

    @Id
    @GeneratedValue
    private Long id;

    @Min(1)
    @Max(10)
    private int numberBetweenOneAndTen;

    @NotEmpty
    private String notEmptyString;

    @PinCode
    private String pinCode;
}
