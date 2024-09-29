package com.dogo.gitgudgang.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("mysql")
@Import(DataSourceAutoConfiguration.class)
public class MySqlConfig {
}
