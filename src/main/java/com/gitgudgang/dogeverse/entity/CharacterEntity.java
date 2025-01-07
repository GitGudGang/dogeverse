package com.gitgudgang.dogeverse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class CharacterEntity {
    @Id
    private UUID id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "character_stat",
            joinColumns = @JoinColumn(name = "character_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "stat_entity_id")
    )
    private Set<StatEntity> stats = new HashSet<>();
}
