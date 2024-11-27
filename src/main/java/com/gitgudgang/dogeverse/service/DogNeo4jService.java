package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.dto.DogDto;
import com.gitgudgang.dogeverse.dto.neo4j.NodeDogDto;
import com.gitgudgang.dogeverse.node.DogNode;
import com.gitgudgang.dogeverse.repository.DogNeo4jRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DogNeo4jService {
    private final ModelMapper modelMapper;
    private final DogNeo4jRepository dogNeo4jRepository;

    public DogDto getDogById(Long id) {
        DogNode dogNeo4j = dogNeo4jRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dog with id " + id + " not found"));
        return modelMapper.map(dogNeo4j, DogDto.class);
    }

    public List<DogDto> getAllDogs() {
        List<DogNode> dogsNeo4j = dogNeo4jRepository.findAll();
        return dogsNeo4j.stream()
            .map(dogNeo4j -> modelMapper.map(dogNeo4j, DogDto.class))
            .collect(Collectors.toList());
    }

    public List<NodeDogDto> getAllDogNames() {
        return dogNeo4jRepository.getAllDogNames();
    }
}

