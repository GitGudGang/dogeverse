package com.gitgudgang.dogeverse.Datasources.Primary.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.AttackTypeClass;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class CharacterStats {
    @Id
    private UUID characterStatsId;
    private int strength;
    private int intelligence; 
    private int dexterity;

    @OneToOne(mappedBy = "characterStatsCharacterStatsId")
    private Set<Character> characters = new HashSet<>();
    
}
