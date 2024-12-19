package com.gitgudgang.dogeverse.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.gitgudgang.dogeverse.domain.Dog;
import com.gitgudgang.dogeverse.domain.Stat;

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

    private ArrayList<DogDto> dogs;

    private List<Stat> stats; //TODO: Should contain StatDtos, not Stats
}
