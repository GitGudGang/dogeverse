package com.gitgudgang.dogeverse.repository;

import com.gitgudgang.dogeverse.entity.DogNeo4j;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogNeo4jRepository extends Neo4jRepository<DogNeo4j, Long> {
}