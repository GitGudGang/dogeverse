package com.gitgudgang.dogeverse.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration(proxyBeanMethods = false)
@Import(DataSourceAutoConfiguration.class)
public class MySqlConfig {

    @Qualifier("readAccess")
	@Bean(defaultCandidate = false)
	@ConfigurationProperties("app.datasource")
	public HikariDataSource readAccessDataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	} 

    @Bean(name = "transactionManager")
    @Primary
    public PlatformTransactionManager mysqlTransactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}