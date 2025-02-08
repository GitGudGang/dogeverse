package com.gitgudgang.dogeverse.Datasources.Primary.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.AttackTypeClass;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class SkillBaseData {
    @Id
    private UUID skill_base_data_id;

    private String name;

    @Enumerated(EnumType.STRING)
    private AttackTypeClass attack_type;

    private String description;
}
