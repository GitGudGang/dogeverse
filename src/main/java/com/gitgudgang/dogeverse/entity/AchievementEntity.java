package com.gitgudgang.dogeverse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class AchievementEntity {

    @Id
    private UUID id;
    private String name;
    private int successes;
    private String description;
    private final int basic = 50;
    private final int intermediate = 100;
    private final int advanced = 150;
}
