package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.document.DogDocument;
import com.gitgudgang.dogeverse.domain.DatabaseType;
import com.gitgudgang.dogeverse.domain.Dog;
import com.gitgudgang.dogeverse.entity.DogEntity;
import com.gitgudgang.dogeverse.exception.DogNotFoundException;
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
    private final RepositoryAdapter<Dog, DogDocument, UUID> dogMongoRepository;


    public DogService(DogJpaRepository dogJpaRepository, DogNeo4jRepository dogNeo4jRepository, DogMongoRepository dogMongoRepository, ModelMapper modelMapper) {
        this.dogJpaRepository = new RepositoryAdapterImpl<>(dogJpaRepository, modelMapper, Dog.class, DogEntity.class);
        this.dogNeo4jRepository = new RepositoryAdapterImpl<>(dogNeo4jRepository, modelMapper, Dog.class, DogNode.class);
        this.dogMongoRepository = new RepositoryAdapterImpl<>(dogMongoRepository, modelMapper, Dog.class, DogDocument.class);

    }

    public Dog getDog(UUID id) {
        return dogJpaRepository.findById(id).orElseThrow(() -> new DogNotFoundException(id, DatabaseType.MYSQL));
    }

    

    @Transactional
    public Dog saveDog(Dog dog) {
        UUID uuid = UUID.randomUUID();
        System.out.println("ID generated: " + uuid.getMostSignificantBits());
        dog.setId(uuid);
        //TODO: Add dog stats
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

    @Transactional
    public void deleteDogById(UUID id) {
        dogJpaRepository.deleteById(id);
        dogMongoRepository.deleteById(id);
        dogNeo4jRepository.deleteById(id);
    }

    @Transactional
    public Dog editDog(UUID id, Dog dog) {
        var existingDog = dogJpaRepository.findById(id).orElseThrow(() -> new DogNotFoundException(id, DatabaseType.MYSQL));

        if (!existingDog.equals(dog)) {
            dogJpaRepository.save(dog);
        }
        existingDog = dogNeo4jRepository.findById(id).orElseThrow(() -> new DogNotFoundException(id, DatabaseType.NEO4J));
        if (!existingDog.equals(dog)) {
            dogNeo4jRepository.save(dog);
        }
        existingDog = dogMongoRepository.findById(id).orElseThrow(() -> new DogNotFoundException(id, DatabaseType.MONGODB));
        if (!existingDog.equals(dog)) {
            dogMongoRepository.save(dog);
        }
        return dog;
    }
}
