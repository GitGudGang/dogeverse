package com.gitgudgang.dogeverse.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Dog extends Character {

    private String breed;

    private Trainer trainer;

    private List<DogSkill> skills;
}
