package com.severinu.artemisdemo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatasourceConfig {
    @Bean
    @Primary
    @ConfigurationProperties("core.datasource")
    HikariDataSource hikariDataSource () {
        final HikariDataSource datasource =  DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
        return datasource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(HikariDataSource hikariDataSource) {
        return new JdbcTemplate(hikariDataSource);
    }
}
