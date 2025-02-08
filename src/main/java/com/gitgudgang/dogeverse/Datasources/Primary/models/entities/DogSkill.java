package com.gitgudgang.dogeverse.Datasources.Primary.models.entity;

import java.util.UUID;
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
@IdClass(DogSkill.class)
public class DogSkill {
    
    @Id
    private UUID dog_skill_id;
    private int damage;

    @Id
    @JoinColumn(name = "skill_base_data_id")
    private UUID dog_acquired_skills_dog_acquired_skills_id;
}
