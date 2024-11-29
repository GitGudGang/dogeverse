package com.gitgudgang.dogeverse.dto;

import lombok.*;

import java.util.UUID;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DogDto {
    private UUID id;

    private String name;
}
