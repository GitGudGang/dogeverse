package com.gitgudgang.dogeverse.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gitgudgang.dogeverse.Datasources.Primary.models.document.TrainerDocument;
import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.DatabaseType;
import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.DogClass;
import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.TrainerClass;
import com.gitgudgang.dogeverse.Datasources.Primary.models.entity.Trainer;
import com.gitgudgang.dogeverse.exception.TrainerNotFoundException;
import com.gitgudgang.dogeverse.node.TrainerNode;
import com.gitgudgang.dogeverse.repository.RepositoryAdapter;
import com.gitgudgang.dogeverse.repository.RepositoryAdapterImpl;
import com.gitgudgang.dogeverse.repository.TrainerJpaRepository;
import com.gitgudgang.dogeverse.repository.TrainerMongoRepository;
import com.gitgudgang.dogeverse.repository.TrainerNeo4jRepository;

@Service
public class TrainerService {

    private final RepositoryAdapter<TrainerClass, Trainer, UUID> trainerJpaRepository;
    private final RepositoryAdapter<TrainerClass, TrainerNode, UUID> trainerNeo4jRepository;
    private final RepositoryAdapter<TrainerClass, TrainerDocument, UUID> trainerMongoRepository;
    private final DogService dogService;

    public TrainerService(
            TrainerJpaRepository trainerJpaRepository,
            TrainerNeo4jRepository trainerNeo4jRepository,
            TrainerMongoRepository trainerMongoRepository,
            ModelMapper modelMapper, DogService dogService
    ) {
        this.trainerJpaRepository = new RepositoryAdapterImpl<>(trainerJpaRepository, modelMapper, TrainerClass.class, Trainer.class);
        this.trainerNeo4jRepository = new RepositoryAdapterImpl<>(trainerNeo4jRepository, modelMapper, TrainerClass.class, TrainerNode.class);
        this.trainerMongoRepository = new RepositoryAdapterImpl<>(trainerMongoRepository, modelMapper, TrainerClass.class, TrainerDocument.class);
        this.dogService = dogService;
    }

    public TrainerClass getTrainer(UUID id) {
        return trainerJpaRepository.findById(id).orElseThrow(() -> new TrainerNotFoundException(id, DatabaseType.MYSQL));
    }

     public List<TrainerClass> getAllTrainers() {
        return StreamSupport.stream(trainerJpaRepository.findAll().spliterator(), false)
                            .collect(Collectors.toList());
    }

    @Transactional
    public TrainerClass createTrainer(TrainerClass trainer) {
        trainer.setId(UUID.randomUUID());
        return saveTrainer(trainer);
    }

    private TrainerClass saveTrainer(TrainerClass trainer) {
        trainerJpaRepository.save(trainer);
        trainerNeo4jRepository.save(trainer);
        trainerMongoRepository.save(trainer);
        return trainer;
    }

    @Transactional
    public TrainerClass updateTrainer(UUID id, TrainerClass trainer) {

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
    public TrainerClass addDogToTrainer(UUID id, DogClass dog) {
        var trainer = getTrainer(id);
        var savedDog = dogService.saveDog(dog);
        trainer.getDogs().add(savedDog);
        return saveTrainer(trainer);
    }
}
