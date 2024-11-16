package com.gitgudgang.dogeverse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class DogeverseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogeverseApplication.class, args);
    }
}
