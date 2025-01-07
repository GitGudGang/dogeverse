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

    @ManyToOne()
    @JoinTable(name = "trainer_dogs",
            joinColumns = @JoinColumn(name = "trainer_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "dog_entity_id"))
    private TrainerEntity trainer;

    @OneToMany(mappedBy = "dog", cascade = CascadeType.ALL)
    private List<SkillEntity> skills;
}
