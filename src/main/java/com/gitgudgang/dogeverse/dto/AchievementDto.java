package com.gitgudgang.dogeverse.dto;

import lombok.*;

import java.util.UUID;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AchievementDto {

    private UUID id;
    private int advanced;
    private int basic;
    private String description;
    private int intermediate;
    private String name;
    private int successes;
    // private final int basic = 50;
    // private final int intermediate = 100;
    // private final int advanced = 150;
}