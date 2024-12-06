package com.gitgudgang.dogeverse.config;

import com.gitgudgang.dogeverse.domain.Dog;
import com.gitgudgang.dogeverse.domain.Trainer;
import com.gitgudgang.dogeverse.domain.builder.TrainerBuilder;
import com.gitgudgang.dogeverse.entity.AchievementEntity;
import com.gitgudgang.dogeverse.domain.builder.AchievementBuilder;
import com.gitgudgang.dogeverse.domain.builder.DogBuilder;
import com.gitgudgang.dogeverse.repository.AchievementRepository;
import com.gitgudgang.dogeverse.service.DogService;
import com.gitgudgang.dogeverse.service.TrainerService;
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
    private final TrainerService trainerService;

    private void generateAndInsertDogs(int n) {
        IntStream.range(0, n)
                .mapToObj(_ -> generateDog())
                .forEach(dogService::saveDog);
    }

    private Dog generateDog() {
        return DogBuilder.create()
                .withName(faker.dog().name())
                .withBreed(faker.dog().breed())
                .withStats()
                .build();
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


    private void generateAdnInsertTrainers(int n) {
        IntStream.range(0, n)
                .mapToObj(_ -> generateTrainer())
                .forEach(trainerService::saveTrainer);
    }

    private Trainer generateTrainer() {
        return TrainerBuilder.create()
                .withName(faker.name().firstName())
                .withStats()
                .build();
    }


    @Override
    public void run(ApplicationArguments args) {
        generateAndInsertDogs(10);
        log.info("Dogs generated");
        generateAndInsertAchievements();
        generateAdnInsertTrainers(10);
        log.info("Trainers generated");
    }
}
