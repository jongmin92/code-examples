package com.jongmin.ex

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.NestedConfigurationProperty
import org.springframework.validation.annotation.Validated
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

@Validated
@ConstructorBinding
@ConfigurationProperties(prefix = "mail")
data class ImmutableConfigProperties(
        @get:NotBlank
        val hostName: String,
        @get:Min(0) @get:Max(65535)
        val port: Int,
        @get:NotBlank
        val from: String,
        @NestedConfigurationProperty
        val credentials: Credentials
)
