package com.gitgudgang.dogeverse.Datasources.Primary.models.entity;

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
public class Skill {
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "dog_id", nullable = false)
    private Dog dog;

    @ManyToOne
    @JoinColumn(name = "skill_base_data_id")
    private SkillBaseData skillBaseData;

    private int baseValue;

    private int totalValue;

    private int successes;
}
