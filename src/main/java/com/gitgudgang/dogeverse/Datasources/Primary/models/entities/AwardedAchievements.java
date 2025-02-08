package com.gitgudgang.dogeverse.Datasources.Primary.models.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.ThreeCompositeKeysClass;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.OverridesAttribute;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class AwardedAchievements {

    @EmbeddedId
    @AttributeOverride(name = "key1", column = @Column(name = "trainer_trainer_id") )
    @AttributeOverride(name = "key2", column = @Column(name = "character_character_id"))
    @AttributeOverride(name = "key3", column = @Column(name = "achievement_achievement_id"))
    private ThreeCompositeKeysClass id;

    @ManyToOne
    @JoinColumn(name = "trainer_trainer_id" ,referencedColumnName = "trainer_id")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "achievement_achievement_id",  referencedColumnName="achievement_id")
    private Achievement achievement;
    
}
