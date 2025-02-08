package com.gitgudgang.dogeverse.Datasources.Primary.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Character {
  
    @Id
    private UUID characterId;
  
    private String name;
    private int level;

    @OneToOne
    @JoinColumn(name = "character_stats_character_stats_id" , referencedColumnName = "character_stats_id")
    private CharacterStats characterStats;

}
