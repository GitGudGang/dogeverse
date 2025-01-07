package com.gitgudgang.dogeverse.config;

import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryRead",
        transactionManagerRef = "transactionManagerRead",
		basePackages = "com.gitgudgang.dogeverse.AchievementReadRepo")
public class DatasourceReadOnlyConfig {

	@Bean(name = "dataSourceRead")
    @ConfigurationProperties(prefix = "read.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "entityManagerFactoryRead")
    public LocalContainerEntityManagerFactoryBean readEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("dataSourceRead") DataSource dataSource) {

        return builder
                .dataSource(dataSource)
                .packages("com.gitgudgang.dogeverse.entity")
                // .persistenceUnit("db2")
                .build();
    }

    @Bean(name = "transactionManagerRead")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactoryRead") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    //for JDBC communication
    @Bean(name = "jdbcTemplateRead")
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSourceRead") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    //for JDBC communication
    @Bean(name = "NamedParameterJdbcTemplateRead")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("dataSourceRead") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
	

}