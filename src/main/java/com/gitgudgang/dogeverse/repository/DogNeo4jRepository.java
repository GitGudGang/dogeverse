package com.gitgudgang.dogeverse.repository;

import com.gitgudgang.dogeverse.dto.neo4j.NodeDogDto;
import com.gitgudgang.dogeverse.node.DogNode;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.neo4j.repository.query.Query;

@Repository
public interface DogNeo4jRepository extends Neo4jRepository<DogNode, Long> {
        @Query("MATCH (d:Dog) RETURN d.name AS name")
        List<NodeDogDto> getAllDogNames();
}