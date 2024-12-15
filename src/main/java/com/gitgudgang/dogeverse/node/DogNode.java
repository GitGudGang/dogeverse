package com.gitgudgang.dogeverse.node;

import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
public class DogNode {

    @Id
    private UUID id;

    @Version
    private Long version;

    private String name;

    private String breed;

    @Relationship(type = "HAS_ACHIEVEMENT", direction = Relationship.Direction.OUTGOING)
    private List<AchievementNode> achievements = new ArrayList<>();
    
    @Relationship(type = "HAS_STATS", direction = Relationship.Direction.OUTGOING)
    private List<StatNode> stats;

    @Relationship(type = "HAS_TRAINER", direction = Relationship.Direction.OUTGOING)
    private TrainerNode trainer;

    @Relationship(type = "HAS_SKILL", direction = Relationship.Direction.OUTGOING)
    private List<SkillAssignmentEdge> skills;
}
