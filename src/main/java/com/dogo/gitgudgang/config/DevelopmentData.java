package com.dogo.gitgudgang.config;

import com.dogo.gitgudgang.entity.Dog;
import com.dogo.gitgudgang.entity.builder.DogBuilder;
import com.dogo.gitgudgang.repository.DogRepository;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import java.util.stream.IntStream;

@AllArgsConstructor
@Controller
@Profile("!test")
public class DevelopmentData implements ApplicationRunner {

    private final Faker faker;
    private final DogRepository dogRepository;

    private void generateAndInsertDogs(int n) {
        IntStream.range(0, n)
                .mapToObj(i -> generateFakeDog())
                .forEach(dogRepository::save);
    }

    private Dog generateFakeDog() {
        return DogBuilder.create().withName(faker.dog().name()).build();
    }

    @Override
    public void run(ApplicationArguments args) {
        generateAndInsertDogs(10);
    }
}
