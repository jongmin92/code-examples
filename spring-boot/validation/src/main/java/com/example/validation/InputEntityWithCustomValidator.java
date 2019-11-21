package com.example.validation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.example.validation.service.OnCreate;
import com.example.validation.service.OnUpdate;

import lombok.Data;

@Data
@Entity
public class InputEntityWithCustomValidator {

    @Id
    @GeneratedValue
    @NotNull(groups = OnUpdate.class)
    @Null(groups = OnCreate.class)
    private Long id;

    @Min(1)
    @Max(10)
    private int numberBetweenOneAndTen;

    @NotEmpty
    private String notEmptyString;

    @PinCode
    private String pinCode;
}
