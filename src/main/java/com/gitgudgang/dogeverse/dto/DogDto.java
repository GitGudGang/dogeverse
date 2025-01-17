package com.gitgudgang.dogeverse.dto;

import com.gitgudgang.dogeverse.domain.Stat;
import lombok.*;

import java.util.List;
import java.util.UUID;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DogDto {

    private UUID id;

    private String name;

    private String breed;

    private List<Stat> stats;
}
