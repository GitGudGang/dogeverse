package com.gitgudgang.dogeverse.Datasources.Primary.models.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatClass {
    private UUID id;

    private AttackTypeClass statType;

    private int statValue; // 1 - 10
}
