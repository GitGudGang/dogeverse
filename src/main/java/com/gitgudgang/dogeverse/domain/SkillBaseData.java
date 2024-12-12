package com.gitgudgang.dogeverse.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SkillBaseData {

    private UUID id;

    private String name;

    private StatType statType;

    private String description;
}
