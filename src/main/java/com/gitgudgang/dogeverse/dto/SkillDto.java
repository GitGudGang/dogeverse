package com.gitgudgang.dogeverse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SkillDto {

    private UUID id;

    private UUID dogId;

    private UUID skillBaseDataId;

    private int baseValue;

    private int totalValue;

    private int successes;
}
