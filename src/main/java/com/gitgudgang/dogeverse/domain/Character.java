package com.gitgudgang.dogeverse.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Character {
    private String name;
    private Set<Stat> stats;
}
