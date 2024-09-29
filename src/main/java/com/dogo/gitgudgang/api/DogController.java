package com.dogo.gitgudgang.api;

import com.dogo.gitgudgang.dto.DogDto;
import com.dogo.gitgudgang.service.DogService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/dogs")
public class DogController {

    private DogService dogService;
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    DogDto getDog(@PathVariable int id) {
        dogService.getDog(id);
        return modelMapper.map(dogService.getDog(id), DogDto.class);
    }
}
