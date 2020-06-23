package com.jongmin.ex

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
/**
 * Spring Boot 2.2부터 classpath 기준으로 @ConfigurationProperties를 찾아 빈으로 등록 가능.
 * - Spring Boot 2.2.0에서는 default로 enabled되어 있음.
 * - Spring Boot 2.2.1부터는 @ConfigurationPropertiesScan을 사용해야 한다.
 *
 * https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.2-Release-Notes#configurationproperties-scanning
 */
@ConfigurationPropertiesScan
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
