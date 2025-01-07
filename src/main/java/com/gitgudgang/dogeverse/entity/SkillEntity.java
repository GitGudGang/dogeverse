package com.gitgudgang.dogeverse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class SkillEntity {
    @Id
    private UUID id;

    @ManyToOne
    @JoinTable(name = "dog_skill",
            joinColumns = @JoinColumn(name = "skill_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "dog_entity_id")
    )
    private DogEntity dog;

    @ManyToOne
    @JoinColumn(name = "skill_base_data_id")
    private SkillBaseDataEntity skillBaseData;

    private int baseValue;

    private int totalValue;

    private int successes;
}
