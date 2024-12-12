package com.gitgudgang.dogeverse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class DogEntity extends CharacterEntity {
    private String breed;

    @ManyToOne
    private TrainerEntity trainer;

    @OneToMany
    private List<DogSkillEntity> skills;
}
