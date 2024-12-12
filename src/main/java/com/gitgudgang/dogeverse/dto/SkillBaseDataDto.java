package com.gitgudgang.dogeverse.dto;

import com.gitgudgang.dogeverse.domain.StatType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SkillBaseDataDto {
    private UUID id;

    private String name;

    private StatType statType;

    private String description;
}
