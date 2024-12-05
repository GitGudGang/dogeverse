package com.gitgudgang.dogeverse.repository;


import com.gitgudgang.dogeverse.entity.AchievementEntity;

import java.util.UUID;

import org.springframework.data.neo4j.repository.Neo4jRepository;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementRepository extends Neo4jRepository<AchievementEntity, UUID> {
    
}
