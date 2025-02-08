package com.gitgudgang.dogeverse.Datasources.Primary.models.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SkillBaseDataClass {

    private UUID id;

    private String name;

    private AttackTypeClass statType;

    private String description;
}
