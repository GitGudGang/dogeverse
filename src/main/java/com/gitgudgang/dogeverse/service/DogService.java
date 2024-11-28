package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.entity.Dog;
import com.gitgudgang.dogeverse.entity.mongodb.DogMongo;
import com.gitgudgang.dogeverse.dto.DogDto;
import com.gitgudgang.dogeverse.entity.neo4j.DogNeo4j;
import com.gitgudgang.dogeverse.repository.DogMongoRepository;
import com.gitgudgang.dogeverse.repository.DogRepository;
import com.gitgudgang.dogeverse.repository.neo4j.DogNeo4jRepository;

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
    private final DogMongoRepository dogMongoRepository;
    private final ModelMapper modelMapper;

    public Dog getDog(int id) {
        return dogRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("dog with id " + id + " not found"));
    }

    @Transactional
    public DogDto saveDogInAllDatabases(Dog dog) {
        dogRepository.save(dog);
        saveDogInMySQL(dog);
        saveDogInNeo4j(dog);
        saveDogInMongoDB(dog);
        return modelMapper.map(dog, DogDto.class);
    }

    public Dog saveDogInMySQL(Dog dog) {
        return dogRepository.save(dog);
    }

    public void saveDogInMongoDB(Dog dog) {
        DogMongo dogMongo = modelMapper.map(dog, DogMongo.class);
        dogMongoRepository.save(dogMongo);
    }

    public void saveDogInNeo4j(Dog dog) {
        DogNeo4j dogNeo4j = modelMapper.map(dog, DogNeo4j.class);
        dogNeo4jRepository.save(dogNeo4j);
    }

    public void deleteDogFromMySQL(Dog dog) {
        dogRepository.delete(dog);
    }

    public void deleteDogInNeo4j(Dog dog) {
        DogNeo4j dogNeo4j = modelMapper.map(dog, DogNeo4j.class);
        dogNeo4jRepository.delete(dogNeo4j);
    }

    

}
