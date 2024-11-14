package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.entity.DogNeo4j;
import com.gitgudgang.dogeverse.repository.DogNeo4jRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DogNeo4jService {

    private final DogNeo4jRepository dogNeo4jRepository;

    public DogNeo4j getDogById(Long id) {
        return dogNeo4jRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dog with id " + id + " not found"));
    }

    public List<DogNeo4j> getAllDogs() {
        return dogNeo4jRepository.findAll();
    }
}

