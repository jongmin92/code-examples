package com.jongmin.ex

import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotBlank

@Validated
class Credentials {
    @NotBlank
    lateinit var userName: String
    @NotBlank
    lateinit var password: String
}
