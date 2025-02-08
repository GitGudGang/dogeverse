package com.gitgudgang.dogeverse.dto;

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
public class SkillBaseDataDto {
    private UUID id;

    private String name;

    private AttackTypeClass statType;

    private String description;
}
