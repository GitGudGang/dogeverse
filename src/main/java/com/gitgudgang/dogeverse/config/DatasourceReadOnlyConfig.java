package com.gitgudgang.dogeverse.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import jakarta.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;
// @Configuration(proxyBeanMethods = false)
// @Import(DataSourceAutoConfiguration.class)

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryReadOnly",
        transactionManagerRef = "transactionManagerReadOnly",
        basePackages = {"com.gitgudgang.dogeverse.repository"})
public class DatasourceReadOnlyConfig {

    // private Environment env;

    @Bean(name = "dataSourceReadOnly")
    @ConfigurationProperties(prefix = "db-read-only.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "entityManagerFactoryReadOnly")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("dataSourceReadOnly") DataSource dataSource) {

        //mapping properties from the application.properties file
        // Map<String, Object> properties = new HashMap<>();
        // properties.put("hikari.maximum-pool-size",
        //         env.getProperty("db1.datasource.hikari.maximum-pool-size"));

        return builder
                .dataSource(dataSource)
                .packages("com.gitgudgang.dogeverse.entity")
                .persistenceUnit("db-read-only")
                // .properties(properties)
                .build();
    }
    
    //for JDBC communication
    @Bean(name = "jdbcTemplateReadOnly")
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSourceReadOnly") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    //for JDBC communication
    @Bean(name = "namedParameterJdbcTemplateReadOnly")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("dataSourceReadOnly") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
	

    @Bean(name = "transactionManagerReadOnly")
    public PlatformTransactionManager mysqlTransactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}