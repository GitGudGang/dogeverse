package com.gitgudgang.dogeverse.domain;

import com.gitgudgang.dogeverse.entity.CharacterEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Dog extends Character {
    private String breed;
    private Trainer trainer;
}
