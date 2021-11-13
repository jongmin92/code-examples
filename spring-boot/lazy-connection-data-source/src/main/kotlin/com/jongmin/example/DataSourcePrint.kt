package com.jongmin.example

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy
import org.springframework.stereotype.Component
import javax.sql.DataSource

@Component
class DataSourcePrint(
    private val dataSource: DataSource
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        val lazyConnectionDataSourceProxy = ((dataSource as LazyConnectionDataSourceProxy).targetDataSource)
        val datasource = lazyConnectionDataSourceProxy as HikariDataSource
        println("active connection: ${datasource.hikariPoolMXBean.activeConnections}")
        println("idle connection: ${datasource.hikariPoolMXBean.idleConnections}")
    }
}
