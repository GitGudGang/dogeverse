package com.gitgudgang.dogeverse.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.StatClass;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DogDto {

    private UUID id;

    private String name;

    private String breed;

    private List<StatClass> stats;
}
