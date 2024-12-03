package com.gitgudgang.dogeverse.domain;

import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public abstract class Character {
    private UUID id;

    private String name;

    private Set<Stat> stats;
}
