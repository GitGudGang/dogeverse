package com.gitgudgang.dogeverse.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.gitgudgang.dogeverse.domain.Dog;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gitgudgang.dogeverse.document.TrainerDocument;
import com.gitgudgang.dogeverse.domain.DatabaseType;
import com.gitgudgang.dogeverse.domain.Trainer;
import com.gitgudgang.dogeverse.entity.TrainerEntity;
import com.gitgudgang.dogeverse.exception.TrainerNotFoundException;
import com.gitgudgang.dogeverse.node.TrainerNode;
import com.gitgudgang.dogeverse.repository.RepositoryAdapter;
import com.gitgudgang.dogeverse.repository.RepositoryAdapterImpl;
import com.gitgudgang.dogeverse.repository.TrainerJpaRepository;
import com.gitgudgang.dogeverse.repository.TrainerMongoRepository;
import com.gitgudgang.dogeverse.repository.TrainerNeo4jRepository;

@Service
public class TrainerService {

    private final RepositoryAdapter<Trainer, TrainerEntity, UUID> trainerJpaRepository;
    private final RepositoryAdapter<Trainer, TrainerNode, UUID> trainerNeo4jRepository;
    private final RepositoryAdapter<Trainer, TrainerDocument, UUID> trainerMongoRepository;
    private final DogService dogService;

    public TrainerService(
            TrainerJpaRepository trainerJpaRepository,
            TrainerNeo4jRepository trainerNeo4jRepository,
            TrainerMongoRepository trainerMongoRepository,
            ModelMapper modelMapper, DogService dogService
    ) {
        this.trainerJpaRepository = new RepositoryAdapterImpl<>(trainerJpaRepository, modelMapper, Trainer.class, TrainerEntity.class);
        this.trainerNeo4jRepository = new RepositoryAdapterImpl<>(trainerNeo4jRepository, modelMapper, Trainer.class, TrainerNode.class);
        this.trainerMongoRepository = new RepositoryAdapterImpl<>(trainerMongoRepository, modelMapper, Trainer.class, TrainerDocument.class);
        this.dogService = dogService;
    }

    public Trainer getTrainer(UUID id) {
        return trainerJpaRepository.findById(id).orElseThrow(() -> new TrainerNotFoundException(id, DatabaseType.MYSQL));
    }

     public List<Trainer> getAllTrainers() {
        return StreamSupport.stream(trainerJpaRepository.findAll().spliterator(), false)
                            .collect(Collectors.toList());
    }

    @Transactional
    public Trainer createTrainer(Trainer trainer) {
        trainer.setId(UUID.randomUUID());
        return saveTrainer(trainer);
    }

    private Trainer saveTrainer(Trainer trainer) {
        trainerJpaRepository.save(trainer);
        trainerNeo4jRepository.save(trainer);
        trainerMongoRepository.save(trainer);
        return trainer;
    }

    @Transactional
    public Trainer updateTrainer(UUID id, Trainer trainer) {

        trainerJpaRepository.findById(id).orElseThrow(() -> new TrainerNotFoundException(id, DatabaseType.MYSQL));
        trainerNeo4jRepository.findById(id).orElseThrow(() -> new TrainerNotFoundException(id, DatabaseType.NEO4J));
        trainerMongoRepository.findById(id).orElseThrow(() -> new TrainerNotFoundException(id, DatabaseType.MONGODB));

        saveTrainer(trainer);

        return trainer;
    }

    @Transactional
    public void deleteTrainer(UUID id) {
        trainerJpaRepository.deleteById(id);
        trainerNeo4jRepository.deleteById(id);
        trainerMongoRepository.deleteById(id);
    }

    @Transactional
    public Trainer addDogToTrainer(UUID id, Dog dog) {
        var trainer = getTrainer(id);
        var savedDog = dogService.saveDog(dog);
        trainer.getDogs().add(savedDog);
        return saveTrainer(trainer);
    }
}