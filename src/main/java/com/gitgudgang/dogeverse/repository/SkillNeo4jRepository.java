package com.gitgudgang.dogeverse.repository;

import com.gitgudgang.dogeverse.node.SkillNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface SkillNeo4jRepository extends Neo4jRepository<SkillNode, UUID> {
}
