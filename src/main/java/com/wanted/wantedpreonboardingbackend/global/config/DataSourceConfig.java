package com.wanted.wantedpreonboardingbackend.global.config;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


public class DataSourceConfig {

//    @Bean
//    @ConfigurationProperties("spring.datasource.hikari")
//    public DataSource dataSource() throws SQLException {
//        Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092").start();
//
//        return new com.zaxxer.hikari.HikariDataSource();
//    }
}