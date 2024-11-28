package com.gitgudgang.dogeverse.dto;

import java.util.ArrayList;
import java.util.UUID;

import com.gitgudgang.dogeverse.api.StatController;
import com.gitgudgang.dogeverse.entity.DogEntity;
import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainerDto {
    private UUID id;
    private String name;
    private StatController stats;
    private ArrayList<DogEntity> dogs;
}
