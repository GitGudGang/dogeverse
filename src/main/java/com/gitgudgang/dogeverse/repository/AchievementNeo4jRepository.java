package com.gitgudgang.dogeverse.repository;

import com.gitgudgang.dogeverse.entity.AchievementEntity;
import com.gitgudgang.dogeverse.node.AchievementNode;

import java.util.UUID;

import org.springframework.data.neo4j.repository.Neo4jRepository;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementNeo4jRepository extends Neo4jRepository<AchievementNode, UUID> {
    
}
