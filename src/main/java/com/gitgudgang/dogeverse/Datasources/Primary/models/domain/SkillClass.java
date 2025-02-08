package com.gitgudgang.dogeverse.Datasources.Primary.models.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SkillClass {
    private UUID id;

    private DogClass dog;

    private SkillBaseDataClass skillBaseData;

    private int baseValue; //TODO: baseValue is the associated stat of the dog

    private int totalValue; //TODO: For each 10 successes, totalValue goes up by 1

    private int successes;
}
