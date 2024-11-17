package com.gitgudgang.dogeverse.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Profile;


@Configuration
@Profile("mongo")
//@Import(MongoDataAutoConfiguration.class)
//@EnableMongoRepositories(basePackages = "com.dogo.gitgudgang.repository")
public class MongoConfig {
}
