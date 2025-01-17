package com.gitgudgang.dogeverse.api;
import com.gitgudgang.dogeverse.dto.DogDto;
import com.gitgudgang.dogeverse.service.DogNeo4jService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/neo4j/dogs")
@AllArgsConstructor
public class DogNeo4jController {

    private final DogNeo4jService dogNeo4jService;

    @GetMapping("/{id}")
    public DogDto getDogById(UUID id) {
        return dogNeo4jService.getDogById(id);
    }

    @GetMapping("/")
    public List<DogDto> getAllDogs() {
        return dogNeo4jService.getAllDogs();
    }

    @GetMapping("/names")
    public List<DogDto> getAllDogNames() {
        return dogNeo4jService.getAllDogNames();
    }
}