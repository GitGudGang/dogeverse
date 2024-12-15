package com.gitgudgang.dogeverse.node;

import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Node;

import org.springframework.data.neo4j.core.schema.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Node("SkillBaseData")
public class SkillBaseDataNode {
    @Id
    private UUID id;

    @Version
    private Long version;

    private String name;

    private StatType statType;

    private String description;
}
