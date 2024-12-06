package com.gitgudgang.dogeverse.domain.builder;

import com.gitgudgang.dogeverse.domain.Dog;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.IntStream;

@AllArgsConstructor
public class DogFactory {

    public static List<Dog> createDogs(int count) {
        Faker faker = new Faker();

        return IntStream.range(0, count)
                .mapToObj(_ -> DogBuilder.create()
                    .withName(faker.dog().name())
                    .withBreed(faker.dog().breed())
                    .withStats()
                    .build())
                .toList();
    }
}
