package com.gitgudgang.dogeverse.entity;

import com.gitgudgang.dogeverse.domain.StatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
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
public class SkillBaseDataEntity {
    @Id
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private StatType statType;

    private String description;
}
