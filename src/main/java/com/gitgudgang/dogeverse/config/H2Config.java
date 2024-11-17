package com.gitgudgang.dogeverse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("h2")
//@EnableJpaRepositories(basePackages = "com.dogo.gitgudgang.repository")
public class H2Config {
}
