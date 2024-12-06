package com.gitgudgang.dogeverse.dto;

import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

import com.gitgudgang.dogeverse.api.StatController;
import com.gitgudgang.dogeverse.domain.Dog;
import com.gitgudgang.dogeverse.domain.Stat;
import com.gitgudgang.dogeverse.entity.DogEntity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class TrainerDto {
    private UUID id;

    private String name;

    private ArrayList<Dog> dogs;

    private Set<Stat> stats;
}
