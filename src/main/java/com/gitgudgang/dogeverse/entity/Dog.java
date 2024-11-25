package com.gitgudgang.dogeverse.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Dog extends Character {
    private String breed;
}
