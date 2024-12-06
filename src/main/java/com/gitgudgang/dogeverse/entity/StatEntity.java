package com.gitgudgang.dogeverse.entity;

import com.gitgudgang.dogeverse.domain.StatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class StatEntity {
    @Id
    private UUID id;

    @Enumerated(EnumType.STRING)
    private StatType statType;

    @Range(min = 1, max = 10)
    private int statValue;
}
