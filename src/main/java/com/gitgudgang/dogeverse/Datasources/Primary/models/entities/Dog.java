package com.gitgudgang.dogeverse.Datasources.Primary.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.Breed;
import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.TwoCompositeKeysClass;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dog extends Character {

    @EmbeddedId
    @AttributeOverride(name = "key1", column = @Column(name = "dog_id"))
    @AttributeOverride(name = "key2", column = @Column(name = "dog_stats_dog_stats_id"))
    @Id
    private TwoCompositeKeysClass id;
    
    @Enumerated(EnumType.STRING)
    private Breed breed;
    
    private String name;

    @OneToOne
    @MapsId("key2") 
    @Id
    @JoinColumn(name = "dog_stats_dog_stats_id", referencedColumnName = "dog_stats_id")
    private DogStats dogStats;  

    @OneToOne
    @Id
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

}
