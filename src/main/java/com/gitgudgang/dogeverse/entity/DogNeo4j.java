package com.gitgudgang.dogeverse.entity;

import org.springframework.data.neo4j.core.schema.Id;
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
@Node("Dog") // Specifies this as a Neo4j node with label "Dog"
public class DogNeo4j {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
