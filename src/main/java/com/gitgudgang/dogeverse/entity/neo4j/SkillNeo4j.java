package com.gitgudgang.dogeverse.entity.neo4j;

import org.springframework.data.neo4j.core.schema.Node;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Node("Achievement")
public class SkillNeo4j {
    private String name;
    private String description;
}
