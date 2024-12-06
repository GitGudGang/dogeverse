package com.gitgudgang.dogeverse.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.gitgudgang.dogeverse.document.TrainerDocument;

@Repository
public interface TrainerMongoRepository extends MongoRepository<TrainerDocument, UUID> {

    @Query("{name:'?0'}")
    TrainerDocument findTrainerByName(String name);

 //   @Query(value="{experience:'?0'}")
 //   List<TrainerDocument> findAllByExperience(int experience);
}
