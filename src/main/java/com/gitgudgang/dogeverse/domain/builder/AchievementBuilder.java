package com.gitgudgang.dogeverse.domain.builder;

import com.gitgudgang.dogeverse.entity.AchievementEntity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AchievementBuilder {
    
     private AchievementEntity achievement;

    public static AchievementBuilder create() {
        var aBuilder = new AchievementBuilder();
        var achievement = new AchievementEntity();
        aBuilder.setAchievement(achievement);
        return aBuilder;
    }
    private void setAchievement(AchievementEntity achievementEntity) {
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

    public AchievementEntity build() {
        var temp = achievement;
        achievement = null;
        return temp;
    }
}
