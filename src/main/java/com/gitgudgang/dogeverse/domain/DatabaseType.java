package com.gitgudgang.dogeverse.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DatabaseType {
    MYSQL("MySQL"),
    MONGODB("MongoDB"),
    NEO4J("Neo4j");

    private final String name;
}
