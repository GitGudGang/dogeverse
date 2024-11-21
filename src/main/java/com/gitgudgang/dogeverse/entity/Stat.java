package com.gitgudgang.dogeverse.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Stat {
    
    @Id
    @GeneratedValue
    private long id;
    private int strength;
    private int dexterity;
    private int intelligence;
}
