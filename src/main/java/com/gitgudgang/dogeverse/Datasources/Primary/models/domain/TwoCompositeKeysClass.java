package com.gitgudgang.dogeverse.Datasources.Primary.models.domain;

import java.util.UUID;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TwoCompositeKeysClass {
    private UUID key1;
    private UUID key2;
}
