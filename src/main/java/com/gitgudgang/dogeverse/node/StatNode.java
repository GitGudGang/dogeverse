package com.gitgudgang.dogeverse.node;


import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Node;

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
@Node("Stat")
public class StatNode {
    @Id
    private UUID id;

    private StatType statType;

    private int statValue;
}
