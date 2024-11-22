package com.gitgudgang.dogeverse.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gitgudgang.dogeverse.dto.DogDto;
import com.gitgudgang.dogeverse.service.DogMongoService;


import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/mongodb/dogs")
@AllArgsConstructor
public class DogMongoController {
    private final DogMongoService dogMongoService;

    @GetMapping("/{id}")
    public DogDto getDogById(String name) {
        return dogMongoService.getDogByName(name);
    }

    @GetMapping
    public List<DogDto> getAllDogsByBreed(String breed) {
        return dogMongoService.getAllDogsByBreed(breed);
    }
}
