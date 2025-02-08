package com.gitgudgang.dogeverse.config;

import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.AchievementClass;
import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.Achievements;
import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.DogClass;
import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.SkillBaseDataClass;
import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.TrainerClass;
import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.builder.AchievementBuilder;
import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.builder.DogFactory;
import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.builder.SkillBaseDataLoader;
import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.builder.TrainerBuilder;
import com.gitgudgang.dogeverse.Datasources.Primary.models.entity.Achievement;
import com.gitgudgang.dogeverse.repository.AchievementMysqlRepository;
import com.gitgudgang.dogeverse.repository.AchievementNeo4jRepository;
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
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Controller
@Profile("!test")
@Slf4j
public class DevelopmentData implements ApplicationRunner {

    private final Faker faker;
    private final DogService dogService;
    private final AchievementMysqlRepository achievementMysqlRepository;
    private final TrainerService trainerService;
    private final SkillBaseDataService skillBaseDataService;
    private final SkillBaseDataJpaRepository skillBaseDataJpaRepository;

    private List<DogClass> generateAndInsertDogs(int n) {
        var dogs = DogFactory.createDogs(n);
        return dogs.stream().map(dogService::saveDog).toList();
    }

    private void generateAndInsertAchievements() {
        IntStream.range(0, 3 )
                .mapToObj(this::generateFakeAchievement)
                .forEach(achievementMysqlRepository::save);
    }

    private Achievement generateFakeAchievement(int i) {
        
        Achievement achievement = new Achievement();
        
        switch (i) {
            case 0:
            achievement.setAchievementId(UUID.randomUUID());
            achievement.setAwardTitle(Achievements.BASIC.getTitle());
            achievement.setDescription(Achievements.BASIC.getDescription());
            achievement.setTriggerPoints(Achievements.BASIC.getTriggerPoint());
                break;
            case 1:
            achievement.setAchievementId(UUID.randomUUID());
            achievement.setAwardTitle(Achievements.MODERATE.getTitle());
            achievement.setDescription(Achievements.MODERATE.getDescription());
            achievement.setTriggerPoints(Achievements.MODERATE.getTriggerPoint());
                break;
            case 2:
            achievement.setAchievementId(UUID.randomUUID());
            achievement.setAwardTitle(Achievements.ADVANCED.getTitle());
            achievement.setDescription(Achievements.ADVANCED.getDescription());
            achievement.setTriggerPoints(Achievements.ADVANCED.getTriggerPoint());
                break;
        
            default:
                break;
        }

        return achievement;
    }

    private void generateAndInsertTrainers(int n, List<DogClass> dogs) {
        List<DogClass> mutableDogs = new ArrayList<>(dogs);
        int dogsPerTrainer = mutableDogs.size() / n;
        int remainder = mutableDogs.size() % n;

        for (int i = 0; i < n; i++) {
            int chunkSize = dogsPerTrainer + (i == n - 1 ? remainder : 0);
            List<DogClass> currentChunk = new ArrayList<>(mutableDogs.subList(0, chunkSize));
            mutableDogs.subList(0, chunkSize).clear();
            trainerService.createTrainer(generateTrainer(currentChunk));
        }
    }

    private TrainerClass generateTrainer(List<DogClass> dogs) {
        return TrainerBuilder.create()
                .withName(faker.name().firstName())
                .withStats()
                .withDogs(dogs)
                .build();
    }

    @Override
    public void run(ApplicationArguments args) {
        var skillBaseData = generateAndInsertSkillBaseData();
        log.info("SkillBaseData generated");

        var dogs = generateAndInsertDogs(20);
        log.info("Dogs generated");

        generateAndInsertTrainers(5, dogs);
        log.info("Trainers generated");

        generateAndInsertAchievements();
        log.info("Achievements generated");
    }

    private Iterable<SkillBaseDataClass> generateAndInsertSkillBaseData() {
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
}
