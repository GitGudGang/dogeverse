package com.gitgudgang.dogeverse.repository.neo4j;


import com.gitgudgang.dogeverse.entity.Achievement;

import org.springframework.data.neo4j.repository.Neo4jRepository;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementRepository extends Neo4jRepository<Achievement, Integer> {
    
}
