package com.example.validation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class InputRequest {

    @Min(1)
    @Max(10)
    private int numberBetweenOneAndTen;

    @NotEmpty
    private String notEmptyString;

    @Pattern(regexp = "^[0-9]{6}$")
    private String pinCode;
}
