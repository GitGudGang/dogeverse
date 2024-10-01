package com.gitgudgang.dogeverse.api;

import com.gitgudgang.dogeverse.dto.DogDto;
import com.gitgudgang.dogeverse.service.DogService;
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
