package com.gitgudgang.dogeverse.Datasources.Primary.models.domain;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public abstract class CharacterClass {
    private UUID id;

    private String name;

    private List<StatClass> stats;
}
