package com.gitgudgang.dogeverse.node;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@RelationshipProperties
public class SkillAssignmentEdge {

    @Id
    @GeneratedValue
    // Must be a Long or String because UUID not natively supported by Neo4j
    private String id;

    private int baseValue;
    private int totalValue;
    private int successes;

    @TargetNode
    private SkillBaseDataNode skillBaseDataNode;
}
