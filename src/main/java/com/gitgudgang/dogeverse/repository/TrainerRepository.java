package com.gitgudgang.dogeverse.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gitgudgang.dogeverse.document.TrainerDocument;

@Repository
public interface TrainerRepository extends MongoRepository<TrainerDocument, UUID> {
}
