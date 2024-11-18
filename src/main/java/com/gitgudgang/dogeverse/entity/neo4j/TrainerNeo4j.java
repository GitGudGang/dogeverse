package com.gitgudgang.dogeverse.entity.neo4j;

import org.springframework.data.neo4j.core.schema.Node;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Node("Achievement")
public class TrainerNeo4j {
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private StatsNeo4j stats;
}
