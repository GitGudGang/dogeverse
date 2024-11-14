package com.gitgudgang.dogeverse.api;

import com.gitgudgang.dogeverse.dto.DogDto;
import com.gitgudgang.dogeverse.service.DogService;
import com.gitgudgang.dogeverse.service.DogNeo4jService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dogs")
@AllArgsConstructor
public class DogController {

    private final DogService dogService;
    private final ModelMapper modelMapper;

    @GetMapping("/{id}")
    public DogDto getDog(@PathVariable int id) {
        return modelMapper.map(dogService.getDog(id), DogDto.class);
    }

    @GetMapping("/all")
    public List<DogDto> getAllDogs() {
        return dogService.getAllDogs().stream()
                         .map(dog -> modelMapper.map(dog, DogDto.class))
                         .collect(Collectors.toList());
    }
}

