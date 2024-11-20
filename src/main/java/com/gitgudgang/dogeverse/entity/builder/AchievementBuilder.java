package com.gitgudgang.dogeverse.entity.builder;

import com.gitgudgang.dogeverse.entity.Achievement;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AchievementBuilder {
    
     private Achievement achievement;

    public static AchievementBuilder create() {
        var aBuilder = new AchievementBuilder();
        var achievement = new Achievement();
        aBuilder.setAchievement(achievement);
        return aBuilder;
    }
    private void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }

    public AchievementBuilder withName(String name) {
        this.achievement.setName(name);
        return this;
    }

    public void withSuccesses(int successCount) 
    {
        this.achievement.setSuccesses(successCount);
    }

    public Achievement build() {
        var temp = achievement;
        achievement = null;
        return temp;
    }
}
