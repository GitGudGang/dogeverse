package com.gitgudgang.dogeverse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
@Entity
public class Trainer extends Character {
    @OneToMany
    private ArrayList<Dog> dogs;
}
