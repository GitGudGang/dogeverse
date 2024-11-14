package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.dto.DogDto;
import com.gitgudgang.dogeverse.entity.Dog;
import com.gitgudgang.dogeverse.entity.DogNeo4j;
import com.gitgudgang.dogeverse.repository.DogRepository;
import com.gitgudgang.dogeverse.repository.DogNeo4jRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.core.env.Profiles;
import org.modelmapper.ModelMapper;

@Service
public class DogService {

    private final DogRepository dogRepository;
    private final DogNeo4jRepository dogNeo4jRepository;
    private final boolean useNeo4j;
    private ModelMapper modelMapper = new ModelMapper();

    public DogService(DogRepository dogRepository, DogNeo4jRepository dogNeo4jRepository, Environment environment) {
        this.dogRepository = dogRepository;
        this.dogNeo4jRepository = dogNeo4jRepository;
        // Determine if Neo4j is active by checking the active profile
        this.useNeo4j = environment.acceptsProfiles(Profiles.of("neo4j"));
    }

    public DogDto getDog(int id) {
    if (useNeo4j) {
        DogNeo4j dogNeo4j = dogNeo4jRepository.findById((long) id)
                .orElseThrow(() -> new EntityNotFoundException("Dog with id " + id + " not found"));
        return modelMapper.map(dogNeo4j, DogDto.class);
    } else {
        Dog dog = dogRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dog with id " + id + " not found"));
        return modelMapper.map(dog, DogDto.class);
    }
}


    // Add other methods with similar conditional logic if needed.
}
