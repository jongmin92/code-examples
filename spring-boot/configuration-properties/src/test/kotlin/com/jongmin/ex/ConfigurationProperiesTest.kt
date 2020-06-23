package com.jongmin.ex

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ConfigurationProperiesTest {

    @Autowired
    lateinit var pojoConfigProperties: PojoConfigProperties

    @Autowired
    lateinit var immutableConfigProperties: ImmutableConfigProperties

    @Test
    fun pojoConfigProperties() {
        assertThat(pojoConfigProperties.hostName).isEqualTo("host@gmail.com")
        assertThat(pojoConfigProperties.port).isEqualTo(9000)
        assertThat(pojoConfigProperties.from).isEqualTo("mailer@gmail.com")

        assertThat(pojoConfigProperties.credentials.userName).isEqualTo("jm")
        assertThat(pojoConfigProperties.credentials.password).isEqualTo("password")
    }

    @Test
    fun immutableConfigProperties() {
        assertThat(immutableConfigProperties.hostName).isEqualTo("host@gmail.com")
        assertThat(immutableConfigProperties.port).isEqualTo(9000)
        assertThat(immutableConfigProperties.from).isEqualTo("mailer@gmail.com")

        assertThat(immutableConfigProperties.credentials.userName).isEqualTo("jm")
        assertThat(immutableConfigProperties.credentials.password).isEqualTo("password")
    }
}
