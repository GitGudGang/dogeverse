package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.document.DogDocument;
import com.gitgudgang.dogeverse.domain.Dog;
import com.gitgudgang.dogeverse.entity.DogEntity;
import com.gitgudgang.dogeverse.node.DogNode;
import com.gitgudgang.dogeverse.repository.*;
import jakarta.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class DogService {

    private final RepositoryAdapter<Dog, DogEntity, UUID> dogJpaRepository;
    private final RepositoryAdapter<Dog, DogNode, UUID> dogNeo4jRepository;
    private final RepositoryAdapter<Dog, DogDocument, UUID> dogMongoRepository; //TODO: ALl dogs must use the same ID (change to UUID for all)


    public DogService(DogJpaRepository dogJpaRepository, DogNeo4jRepository dogNeo4jRepository, DogMongoRepository dogMongoRepository, ModelMapper modelMapper) {
        this.dogJpaRepository = new RepositoryAdapterImpl<>(dogJpaRepository, modelMapper, Dog.class, DogEntity.class);
        this.dogNeo4jRepository = new RepositoryAdapterImpl<>(dogNeo4jRepository, modelMapper, Dog.class, DogNode.class);
        this.dogMongoRepository = new RepositoryAdapterImpl<>(dogMongoRepository, modelMapper, Dog.class, DogDocument.class);

    }

    public Dog getDog(UUID id) {
        return dogJpaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("dog with id " + id + " not found"));
    }

    @Transactional
    public Dog saveDog(Dog dog) {
        dog.setId(UUID.randomUUID());
        dogJpaRepository.save(dog);
        dogNeo4jRepository.save(dog);
        dogMongoRepository.save(dog);
        return dog;
    }

    @Transactional
    public void deleteDog(Dog dog) {
        dogJpaRepository.delete(dog);
        dogMongoRepository.delete(dog);
        dogNeo4jRepository.delete(dog);
    }
}
