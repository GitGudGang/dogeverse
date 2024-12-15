package com.gitgudgang.dogeverse.node;


import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import org.springframework.data.neo4j.core.schema.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Node("Trainer")
public class TrainerNode {

    @Id
    private UUID id;

    @Version
    private Long version ;

    private String name;

    @Relationship(type = "HAS_STATS", direction = Relationship.Direction.OUTGOING)
    private Set<StatNode> stats;

    @Relationship(type = "HAS_DOGS", direction = Relationship.Direction.OUTGOING)
    private List<DogNode> dogs;
}
