package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.entity.Dog;
import com.gitgudgang.dogeverse.repository.DogRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DogService {

    private DogRepository repository;

    public Dog getDog(int id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("dog with id " + id + " not found"));
    }

}
