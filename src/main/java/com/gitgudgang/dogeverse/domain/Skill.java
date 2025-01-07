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

    private Dog dog;

    private SkillBaseData skillBaseData;

    private int baseValue;

    private int totalValue;

    private int successes;
}
