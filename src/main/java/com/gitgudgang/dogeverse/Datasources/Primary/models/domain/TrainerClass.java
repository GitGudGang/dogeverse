package com.gitgudgang.dogeverse.Datasources.Primary.models.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainerClass extends CharacterClass {
    private List<DogClass> dogs;
}
