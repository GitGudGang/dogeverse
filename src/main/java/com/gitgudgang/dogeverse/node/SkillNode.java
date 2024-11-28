package com.gitgudgang.dogeverse.node;

import org.springframework.data.neo4j.core.schema.Node;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Node("Skill")
public class SkillNode {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String description;
}
