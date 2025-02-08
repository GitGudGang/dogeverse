package com.gitgudgang.dogeverse.Datasources.Primary.models.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class DogStats {
    
    @Id
    private UUID dog_stats_id;
    private int strength;
    private int dexterity;
    private int intelligence;
}
