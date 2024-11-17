package com.gitgudgang.dogeverse.entity;

import com.gitgudgang.dogeverse.domain.StatType;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.Range;

public class Stat {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatType statType;

    @Range(min = 1, max = 10)
    private int value;
}
