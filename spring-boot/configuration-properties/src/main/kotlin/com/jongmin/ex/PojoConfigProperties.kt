package com.jongmin.ex

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.NestedConfigurationProperty
import org.springframework.validation.annotation.Validated
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

@Validated
@ConfigurationProperties(prefix = "mail")
class PojoConfigProperties {
    @NotBlank
    lateinit var hostName: String
    @Min(0) @Max(65535)
    var port: Int = 0
    @NotBlank
    lateinit var from: String
    @NestedConfigurationProperty
    var credentials = Credentials()
}
