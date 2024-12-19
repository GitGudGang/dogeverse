package com.gitgudgang.dogeverse.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{name}")
    public DogDto getDogByName(@PathVariable String name) {
        return dogMongoService.getDogByName(name);
    }

    @GetMapping("/{breed}")
    public List<DogDto> getAllDogsByBreed(@PathVariable String breed) {
        return dogMongoService.getAllDogsByBreed(breed);
    }
}
