package com.gitgudgang.dogeverse.domain.builder;

import com.gitgudgang.dogeverse.entity.AchievementAdminEntity;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
public class AchievementBuilder {
    
     private AchievementAdminEntity achievement;

    public static AchievementBuilder create() {
        var aBuilder = new AchievementBuilder();
        var achievement = new AchievementAdminEntity();
        aBuilder.setAchievement(achievement);
        return aBuilder;
    }
    private void setAchievement(AchievementAdminEntity achievementEntity) {
        this.achievement = achievementEntity;
    }

    public AchievementBuilder withName(String name) {
        this.achievement.setName(name);
        return this;
    }

    public void withSuccesses(int successCount) 
    {
        this.achievement.setSuccesses(successCount);
    }

    public AchievementAdminEntity build() {
        var temp = achievement;
        temp.setId(UUID.randomUUID());
        achievement = null;
        return temp;
    }
}
