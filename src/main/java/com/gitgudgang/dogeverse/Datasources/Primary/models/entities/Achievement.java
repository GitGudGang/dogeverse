package com.gitgudgang.dogeverse.Datasources.Primary.models.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Achievement {
    @Id
    private UUID achievementId;
    private String description;
    private String awardTitle;
    private int triggerPoints;

    @OneToMany(mappedBy = "achievement_achievement_id")
    private Set<AwardedAchievements> awardedAchievements = new HashSet<>();
}
