package com.dogo.gitgudgang.config;

import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("neo4j")
//@Import(Neo4jDataAutoConfiguration.class)
public class Neo4jConfig {
}
