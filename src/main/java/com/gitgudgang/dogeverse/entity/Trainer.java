package com.gitgudgang.dogeverse.entity;

import java.util.ArrayList;
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
public class Trainer {
    
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private Stat stats;
    private ArrayList<Dog> dogs;

}
