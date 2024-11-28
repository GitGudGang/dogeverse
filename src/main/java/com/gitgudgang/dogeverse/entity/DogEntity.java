package com.gitgudgang.dogeverse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class DogEntity extends CharacterEntity {
    private String breed;

    @ManyToOne
    //@JoinColumn(name = "trainer_id", nullable = false)
    private TrainerEntity trainer;
}
