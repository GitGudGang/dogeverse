package com.gitgudgang.dogeverse.domain;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Achievement {
    private UUID id;
    private String name;
    private int successes;
    private final int basic = 50;
    private final int intermediate = 100;
    private final int advanced = 150;
    private String description;
}
