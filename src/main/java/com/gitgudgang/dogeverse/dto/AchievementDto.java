package com.gitgudgang.dogeverse.dto;

import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AchievementDto {


    private int id;
    private String name;
    private int successes;
    // private final int basic = 50;
    // private final int intermediate = 100;
    // private final int advanced = 150;
}