package com.gitgudgang.dogeverse.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Skill {
    private UUID id;

    private String name;

    private int baseValue; //TODO: This baseValue

    private int totalValue; //TODO: For each 10 successes, totalValue goes up by 1

    private int successes;
}
