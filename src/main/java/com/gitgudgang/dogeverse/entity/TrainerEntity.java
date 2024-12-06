package com.gitgudgang.dogeverse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class TrainerEntity extends CharacterEntity {
    @OneToMany
    private List<DogEntity> dogs;
}