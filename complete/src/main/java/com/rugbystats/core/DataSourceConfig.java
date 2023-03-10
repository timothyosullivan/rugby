package com.rugbystats.core;

import java.util.Objects;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class DataSourceConfig {

    @Bean
    public DataSource datasource(Environment environment) {
        Logger logger = LoggerFactory.getLogger(Application.class);
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("driver")));
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));

        logger.info("DB Connection Details: {} {} {}", dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());

        return dataSource;
    }
}