package com.gitgudgang.dogeverse.Datasources.Primary.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Trainer extends Character {
    
    @Id
    private UUID trainerId;

    @OneToOne
    @JoinColumn(name = "character_id")
    private UUID character_character_id;

    @OneToMany(mappedBy = "trainer_trainer_id")
    private Set<AwardedAchievements> awardedAchievements = new HashSet<>(); 

}
