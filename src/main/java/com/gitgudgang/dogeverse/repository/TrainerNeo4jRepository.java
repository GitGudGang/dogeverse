package com.gitgudgang.dogeverse.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.gitgudgang.dogeverse.node.TrainerNode;

@Repository
public interface TrainerNeo4jRepository extends Neo4jRepository<TrainerNode, UUID> {

    @Query("MATCH (t:Trainer) RETURN t.name AS name")
    List<TrainerNode> getAllTrainerNames();

    @Query("MATCH (t:Trainer) WHERE t.experience > $experience RETURN t")
    List<TrainerNode> findTrainersByExperience(int experience);
}
