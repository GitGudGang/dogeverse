package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.entity.Dog;
import com.gitgudgang.dogeverse.dto.DogDto;
import com.gitgudgang.dogeverse.entity.DogNeo4j;
import com.gitgudgang.dogeverse.repository.DogNeo4jRepository;
import com.gitgudgang.dogeverse.repository.DogRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DogService {

    private final DogRepository dogRepository;
    private final DogNeo4jRepository dogNeo4jRepository;
    private final ModelMapper modelMapper;

    public Dog getDog(int id) {
        return dogRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("dog with id " + id + " not found"));
    }

    public DogDto saveDogInAllDatabases(Dog dog) {
        Dog savedDog = saveDogInMySQL(dog);
        try {
            saveDogInNeo4j(savedDog);
        } catch (Exception e) {
            // Compensating action: Rollback MySQL save
            dogRepository.delete(savedDog);
            throw new RuntimeException("Failed to save Dog in all databases: " + e.getMessage(), e);
        }
        return modelMapper.map(savedDog, DogDto.class);
    }

    //@Transactional(transactionManager = "mysqlTransactionManager")
    public Dog saveDogInMySQL(Dog dog) {
        return dogRepository.save(dog);
    }

    @Transactional(transactionManager = "neo4jTransactionManager")
    public void saveDogInNeo4j(Dog dog) {
        DogNeo4j dogNeo4j = modelMapper.map(dog, DogNeo4j.class);
        dogNeo4jRepository.save(dogNeo4j);
    }

    //@Transactional(transactionManager = "mysqlTransactionManager")
    public void deleteDogFromMySQL(Dog dog) {
        dogRepository.delete(dog);
    }
}
