package com.gitgudgang.dogeverse.repository;

import com.gitgudgang.dogeverse.entity.DogNeo4j;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.neo4j.repository.query.Query;

@Repository
public interface DogNeo4jRepository extends Neo4jRepository<DogNeo4j, Long> {
        @Query("MATCH (d:Dog) RETURN d.name")
        List<String> getAllDogNames();
}