package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.Datasources.Primary.models.document.DogDocument;
import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.DatabaseType;
import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.DogClass;
import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.SkillClass;
import com.gitgudgang.dogeverse.Datasources.Primary.models.entity.Dog;
import com.gitgudgang.dogeverse.exception.DogNotFoundException;
import com.gitgudgang.dogeverse.node.DogNode;
import com.gitgudgang.dogeverse.repository.*;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DogService {

    private final RepositoryAdapter<DogClass, Dog, UUID> dogJpaRepository;
    private final RepositoryAdapter<DogClass, DogNode, UUID> dogNeo4jRepository;
    private final RepositoryAdapter<DogClass, DogDocument, UUID> dogMongoRepository;
    private final SkillBaseDataService skillBaseDataService;
    private final SkillService skillService;


    public DogService(DogJpaRepository dogJpaRepository, DogNeo4jRepository dogNeo4jRepository, DogMongoRepository dogMongoRepository, SkillBaseDataService skillBaseDataService, SkillService skillService, ModelMapper modelMapper) {
        this.dogJpaRepository = new RepositoryAdapterImpl<>(dogJpaRepository, modelMapper, DogClass.class, Dog.class);
        this.dogNeo4jRepository = new RepositoryAdapterImpl<>(dogNeo4jRepository, modelMapper, DogClass.class, DogNode.class);
        this.dogMongoRepository = new RepositoryAdapterImpl<>(dogMongoRepository, modelMapper, DogClass.class, DogDocument.class);
        this.skillBaseDataService = skillBaseDataService;
        this.skillService = skillService;
    }

    public List<DogClass> getAllDogs() {
        return StreamSupport.stream(dogJpaRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public DogClass getDog(UUID id) {
        return dogJpaRepository.findById(id).orElseThrow(() -> new DogNotFoundException(id, DatabaseType.MYSQL));
    }

    // public Iterable<Dog> getAllDogs() {
    //     DataSourceContextHolder.setDataSourceType("readOnly");
    //     Iterable<Dog> dogs = dogJpaRepository.findAll();
    //     DataSourceContextHolder.clear();
    //     return dogs;
    // }

    @Transactional
    public DogClass saveDog(DogClass dog) {
        dog.setId(UUID.randomUUID());
        dogJpaRepository.save(dog);
        dogNeo4jRepository.save(dog);
        dogMongoRepository.save(dog);
        return dog;
    }

    @Transactional
    public void deleteDog(DogClass dog) {
        dogJpaRepository.delete(dog);
        dogMongoRepository.delete(dog);
        dogNeo4jRepository.delete(dog);
    }

    @Transactional
    public void deleteDogById(UUID id) {
        dogJpaRepository.deleteById(id);
        dogMongoRepository.deleteById(id);
        dogNeo4jRepository.deleteById(id);
    }

    @Transactional
    public DogClass editDog(UUID id, DogClass dog) {
        var existingDog = dogJpaRepository.findById(id).orElseThrow(() -> new DogNotFoundException(id, DatabaseType.MYSQL));

        if (!existingDog.equals(dog)) {
            dogJpaRepository.save(dog);
        }
        existingDog = dogNeo4jRepository.findById(id).orElseThrow(() -> new DogNotFoundException(id, DatabaseType.NEO4J));
        if (!existingDog.equals(dog)) {
            dogNeo4jRepository.save(dog);
        }
        existingDog = dogMongoRepository.findById(id).orElseThrow(() -> new DogNotFoundException(id, DatabaseType.MONGODB));
        if (!existingDog.equals(dog)) {
            dogMongoRepository.save(dog);
        }
        return dog;
    }

    public SkillClass addSkillToDog(UUID id, UUID skillBaseDataId) {

        var dog = dogJpaRepository.findById(id).orElseThrow(() -> new DogNotFoundException(id, DatabaseType.MYSQL));

        var skillBaseData = skillBaseDataService.getSkillBaseData(skillBaseDataId);

        var statType = skillBaseData.getStatType();
        var statValue = 0;
        var matchingStatOptional = dog.getStats().stream()
                .filter(stat -> stat.getStatType().equals(statType))
                .findFirst();
        if (matchingStatOptional.isPresent()) {
            statValue = matchingStatOptional.get().getStatValue();
        } else {
            throw new IllegalArgumentException("No Stat found for statType: " + statType);
        }

        return skillService.createAndSaveDogSkill(dog, skillBaseData, statValue);
    }
}
