package com.gitgudgang.dogeverse.repository;

import com.gitgudgang.dogeverse.document.SkillDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface SkillMongoRepository extends MongoRepository<SkillDocument, UUID> {
}
