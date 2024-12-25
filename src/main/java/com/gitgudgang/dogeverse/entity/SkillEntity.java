package com.gitgudgang.dogeverse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @JoinColumn(name = "dog_id", nullable = false)
    private DogEntity dog;

    @ManyToOne
    @JoinColumn(name = "skill_base_data_id")
    private SkillBaseDataEntity skillBaseData;

    private int baseValue;

    private int totalValue;

    private int successes;
}
