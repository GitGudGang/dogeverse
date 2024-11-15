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

    @Transactional
    public DogDto saveDogInAllDatabases(Dog dog) {
        Dog savedDog = dogRepository.save(dog);
        DogNeo4j dogNeo4j = modelMapper.map(savedDog, DogNeo4j.class);
        dogNeo4jRepository.save(dogNeo4j);
        return modelMapper.map(savedDog, DogDto.class);
    }
}
