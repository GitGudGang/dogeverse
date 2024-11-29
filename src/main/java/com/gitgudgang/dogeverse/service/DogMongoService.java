package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.document.DogDocument;
import com.gitgudgang.dogeverse.dto.DogDto;
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
        DogDocument dogDocument = dogMongoRepository.findDogByName(name);
        if (dogDocument == null) throw new EntityNotFoundException("DogDocument not found");
        return modelMapper.map(dogDocument, DogDto.class);
    }

    public List<DogDto> getAllDogsByBreed(String breed) {
        List<DogDocument> dogsMongo = dogMongoRepository.findAllByBreed(breed);
        return dogsMongo.stream()
            .map(dogDocument -> modelMapper.map(dogDocument, DogDto.class))
            .collect(Collectors.toList());
    }
}

