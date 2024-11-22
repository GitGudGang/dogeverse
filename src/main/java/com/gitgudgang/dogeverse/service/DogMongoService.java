package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.dto.DogDto;
import com.gitgudgang.dogeverse.entity.mongodb.DogMongo;
import com.gitgudgang.dogeverse.repository.DogMongoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DogMongoService {
    private final ModelMapper modelMapper;
    private final DogMongoRepository dogMongoRepository;

    public DogDto getDogByName(String name) {
        DogMongo dogMongo = dogMongoRepository.findDogByName(name);
        if (dogMongo == null) throw new EntityNotFoundException("Dog not found");
        return modelMapper.map(dogMongo, DogDto.class);
    }

    public List<DogDto> getAllDogsByBreed(String breed) {
        List<DogMongo> dogsMongo = dogMongoRepository.findAllByBreed(breed);
        return dogsMongo.stream()
            .map(dogMongo -> modelMapper.map(dogMongo, DogDto.class))
            .collect(Collectors.toList());
    }
}

