package com.gitgudgang.dogeverse.entity;

import com.gitgudgang.dogeverse.domain.StatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class SkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private StatType statType;

    @Range(min = 1, max = 10)
    private int baseValue;

    @Range(min = 1, max = 20)
    private int totalValue;
}