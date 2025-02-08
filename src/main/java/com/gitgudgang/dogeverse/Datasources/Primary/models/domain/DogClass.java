package com.gitgudgang.dogeverse.Datasources.Primary.models.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DogClass extends CharacterClass {

    private String breed;

    private TrainerClass trainer;

    private List<SkillClass> skills;
}
