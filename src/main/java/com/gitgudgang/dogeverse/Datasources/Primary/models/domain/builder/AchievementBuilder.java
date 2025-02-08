package com.gitgudgang.dogeverse.Datasources.Primary.models.domain.builder;

import lombok.NoArgsConstructor;

import java.util.UUID;

import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.AchievementClass;

@NoArgsConstructor
public class AchievementBuilder {
    
     private AchievementClass achievement;

    public static AchievementBuilder create() {
        var aBuilder = new AchievementBuilder();
        var achievement = new AchievementClass();
        aBuilder.setAchievement(achievement);
        return aBuilder;
    }
    private void setAchievement(AchievementClass achievementClass) {
        this.achievement = achievementClass;
    }

    public AchievementBuilder withName(String name) {
        this.achievement.setName(name);
        return this;
    }

    public void withSuccesses(int successCount) 
    {
        this.achievement.setSuccesses(successCount);
    }

    public AchievementClass build() {
        var temp = achievement;
        temp.setId(UUID.randomUUID());
        achievement = null;
        return temp;
    }
}
