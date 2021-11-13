package com.jongmin.example

import com.zaxxer.hikari.HikariDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy
import javax.sql.DataSource

@Configuration
class DataSourceConfig {

    @Bean
    fun lazyDataSource(): DataSource {
        val datasource = HikariDataSource().apply {
            driverClassName = "com.mysql.cj.jdbc.Driver"
            jdbcUrl = "jdbc:mysql://localhost:3306/test"
            username = "root"
            password = "password"
        }
        return LazyConnectionDataSourceProxy(datasource)
    }
}
