package com.gitgudgang.dogeverse.config;

import com.gitgudgang.dogeverse.domain.Dog;
import com.gitgudgang.dogeverse.entity.AchievementEntity;
import com.gitgudgang.dogeverse.entity.DogEntity;
import com.gitgudgang.dogeverse.domain.builder.AchievementBuilder;
import com.gitgudgang.dogeverse.domain.builder.DogBuilder;
import com.gitgudgang.dogeverse.repository.AchievementRepository;
import com.gitgudgang.dogeverse.service.DogService;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Controller
@Profile("!test")
@Slf4j
public class DevelopmentData implements ApplicationRunner {

    private final Faker faker;
    private final DogService dogService;
    private final AchievementRepository achievementRepository;

    private void generateAndInsertDogs(int n) {
        IntStream.range(0, n)
                .mapToObj(i -> generateFakeDog())
                .forEach(dogService::saveDog);
    }

    private Dog generateFakeDog() {
        return DogBuilder.create().withName(faker.dog().name()).withBreed(faker.dog().breed()).build();
    }

    private void generateAndInsertAchievements() {
        IntStream.range(0, 3 )
                .mapToObj(this::generateFakeAchievement)
                .forEach(achievementRepository::save);
    }

    private AchievementEntity generateFakeAchievement(int i) {
        String[] porchDefecationAchievements = new String[]{"Porch Stinker", "Master Pooper", "Life Destroyer"};
        return AchievementBuilder.create().withName(porchDefecationAchievements[i]).build();
    }


    @Override
    public void run(ApplicationArguments args) {
        generateAndInsertDogs(10);
        log.info("Dogs generated");
        generateAndInsertAchievements();
    }
}
