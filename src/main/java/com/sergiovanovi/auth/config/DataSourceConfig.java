package com.sergiovanovi.auth.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.sergiovanovi.auth.entity")
@EnableJpaRepositories("com.sergiovanovi.auth.repository")
@PropertySource("classpath:db.properties")
public class DataSourceConfig {
}
