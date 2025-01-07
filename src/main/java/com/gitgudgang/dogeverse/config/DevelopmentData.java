package com.gitgudgang.dogeverse.config;

import com.gitgudgang.dogeverse.domain.Dog;
import com.gitgudgang.dogeverse.domain.SkillBaseData;
import com.gitgudgang.dogeverse.domain.Trainer;
import com.gitgudgang.dogeverse.domain.builder.DogFactory;
import com.gitgudgang.dogeverse.domain.builder.SkillBaseDataLoader;
import com.gitgudgang.dogeverse.domain.builder.TrainerBuilder;
import com.gitgudgang.dogeverse.entity.AchievementEntity;
import com.gitgudgang.dogeverse.domain.builder.AchievementBuilder;
import com.gitgudgang.dogeverse.repository.AchievementRepository;
import com.gitgudgang.dogeverse.repository.SkillBaseDataJpaRepository;
import com.gitgudgang.dogeverse.service.DogService;
import com.gitgudgang.dogeverse.service.SkillBaseDataService;
import com.gitgudgang.dogeverse.service.TrainerService;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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
    private final SkillBaseDataService skillBaseDataService;
    private final SkillBaseDataJpaRepository skillBaseDataJpaRepository;

    private List<Dog> generateAndInsertDogs(int n) {
        var dogs = DogFactory.createDogs(n);
        return dogs.stream().map(dogService::saveDog).toList();
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

    private void generateAndInsertTrainers(int n, List<Dog> dogs) {
        List<Dog> mutableDogs = new ArrayList<>(dogs);
        int dogsPerTrainer = mutableDogs.size() / n;
        int remainder = mutableDogs.size() % n;

        for (int i = 0; i < n; i++) {
            int chunkSize = dogsPerTrainer + (i == n - 1 ? remainder : 0);
            List<Dog> currentChunk = new ArrayList<>(mutableDogs.subList(0, chunkSize));
            mutableDogs.subList(0, chunkSize).clear();
            trainerService.createTrainer(generateTrainer(currentChunk));
        }
    }

    private Trainer generateTrainer(List<Dog> dogs) {
        return TrainerBuilder.create()
                .withName(faker.name().firstName())
                .withStats()
                .withDogs(dogs)
                .build();
    }

    @Override
    public void run(ApplicationArguments args) {
        clearDatabases();

        var skillBaseData = generateAndInsertSkillBaseData();
        log.info("SkillBaseData generated");

        var dogs = generateAndInsertDogs(6);
        log.info("Dogs generated");

        generateAndInsertTrainers(2, dogs);
        log.info("Trainers generated");

        generateAndInsertAchievements();
        log.info("Achievements generated");
    }

    private Iterable<SkillBaseData> generateAndInsertSkillBaseData() {
        var skillBaseDataFromFile = SkillBaseDataLoader.loadSkillBaseData();
        var existingSkillBaseData = skillBaseDataJpaRepository.findAll();

        Set<String> existingSkillNames = new HashSet<>();
        for (var existingSkill : existingSkillBaseData) {
            existingSkillNames.add(existingSkill.getName());
        }

        var newSkills = skillBaseDataFromFile.stream()
                .filter(skill -> !existingSkillNames.contains(skill.getName()))
                .collect(Collectors.toList());

        return skillBaseDataService.saveAllSkillBaseData(newSkills);
    }

    private void clearDatabases() {
        dogService.clearDatabases();
        trainerService.clearDatabases();
    }
}
