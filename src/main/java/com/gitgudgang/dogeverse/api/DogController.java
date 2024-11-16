package com.gitgudgang.dogeverse.api;

import com.gitgudgang.dogeverse.dto.DogDto;
import com.gitgudgang.dogeverse.entity.Dog;
import com.gitgudgang.dogeverse.service.DogService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/neo4j/dogs")
@AllArgsConstructor
public class DogController {

    private final DogService dogService;
    private final ModelMapper modelMapper;

    @GetMapping("/{id}")
    public DogDto getDog(@PathVariable int id) {
        return modelMapper.map(dogService.getDog(id), DogDto.class);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public DogDto createDog(@RequestBody Dog dog) {
        // Save the dog entity in MySQL and Neo4j
        return dogService.saveDogInAllDatabases(dog);
    }
}

