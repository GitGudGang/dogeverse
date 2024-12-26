package com.gitgudgang.dogeverse.node;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Node("Achievement")
public class AchievementNode {

    @Id
    private UUID id;
    private String name;
    private int successes;
    private String description;
    private final int basic = 50;
    private final int intermediate = 100;
    private final int advanced = 150;
}
