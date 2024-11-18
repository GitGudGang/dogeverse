package com.gitgudgang.dogeverse.entity.neo4j;

import org.springframework.data.neo4j.core.schema.Id;

import java.util.List;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
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
    private List<AchievementNeo4j> achievements;
    private StatsNeo4j stats;
}
