package com.gitgudgang.dogeverse.Datasources.Primary.models.entity;

import java.util.UUID;

import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.TwoCompositeKeysClass;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class DogAcquiredSkills {

    @EmbeddedId
    @AttributeOverride(name = "dogId", column = @Column(name = "dog_id"))
    @AttributeOverride(name = "dogSkillId", column = @Column(name = "dog_skill_id"))
    private TwoCompositeKeysClass id;

    private int skill_executions;

}
