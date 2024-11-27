package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.domain.Dog;
import com.gitgudgang.dogeverse.entity.DogEntity;
import com.gitgudgang.dogeverse.document.DogMongo;
import com.gitgudgang.dogeverse.dto.DogDto;
import com.gitgudgang.dogeverse.node.DogNode;
import com.gitgudgang.dogeverse.repository.DogJpaRepository;
import com.gitgudgang.dogeverse.repository.DogNeo4jRepository;
import com.gitgudgang.dogeverse.repository.DogMongoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DogService {

    private final DogJpaRepository dogJpaRepository;
    private final DogNeo4jRepository dogNeo4jRepository;
    private final DogMongoRepository dogMongoRepository;
    private final ModelMapper modelMapper;

    public DogEntity getDog(int id) {
        return dogJpaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("dog with id " + id + " not found"));
    }

    @Transactional
    public DogDto saveDog(Dog dog) {
        var savedDog = saveToRelationalDb(dog);
        saveToGraphDb(savedDog);
        saveToDocumentDb(savedDog);
        return modelMapper.map(dog, DogDto.class);
    }

    private Dog saveToRelationalDb(Dog dog) {
        var dogEntity = dogJpaRepository.save(modelMapper.map(dog, DogEntity.class));
        return modelMapper.map(dogEntity, Dog.class);
    }

    private Dog saveToDocumentDb(Dog dog) {
        var dogMongo = dogMongoRepository.save(modelMapper.map(dog, DogMongo.class));
        return modelMapper.map(dogMongo, Dog.class);
    }

    private Dog saveToGraphDb(Dog dog) {
        DogNode dogNeo = dogNeo4jRepository.save(modelMapper.map(dog, DogNode.class));
        return modelMapper.map(dogNeo, Dog.class);
    }
    @Transactional
    public void deleteDog(Dog dog) {
        dogJpaRepository.delete(modelMapper.map(dog, DogEntity.class));
        dogMongoRepository.delete(modelMapper.map(dog, DogMongo.class));
        dogNeo4jRepository.delete(modelMapper.map(dog, DogNode.class));
    }
}
