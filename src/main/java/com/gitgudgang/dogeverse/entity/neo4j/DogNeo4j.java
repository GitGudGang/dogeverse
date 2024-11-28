package com.gitgudgang.dogeverse.entity.neo4j;

import org.springframework.data.neo4j.core.schema.Id;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Node("Dog")
public class DogNeo4j {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String breed;

    @Relationship(type = "HAS_ACHIEVEMENT", direction = Relationship.Direction.OUTGOING)
    private List<AchievementNeo4j> achievements = new ArrayList<>();
    
    @Relationship(type = "HAS_STATS", direction = Relationship.Direction.OUTGOING)
    private StatsNeo4j stats;
}