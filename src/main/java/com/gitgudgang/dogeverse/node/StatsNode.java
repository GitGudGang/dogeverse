package com.gitgudgang.dogeverse.node;

import org.springframework.data.neo4j.core.schema.Node;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Node("Stats")
public class StatsNode {
    @Id
    @GeneratedValue
    private Long id;
    private String strength;
    private int dexterity;
    private int intelligence;
}