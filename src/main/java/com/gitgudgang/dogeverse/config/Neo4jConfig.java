package com.gitgudgang.dogeverse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@Configuration
@Profile("neo4j")
@EnableNeo4jRepositories(basePackages = "com.gitgudgang.dogeverse.repository")
public class Neo4jConfig {
    // Additional configuration if needed
}
