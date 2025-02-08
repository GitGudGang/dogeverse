package com.gitgudgang.dogeverse.Datasources.Primary.models.domain;

import lombok.Getter;

@Getter
public enum Achievements {
    BASIC("Porch Stinker", "Basic mischief award", 50),
    MODERATE("Master Pooper", "Moderate mischief award", 100),
    ADVANCED("Life Destroyer", "Advanced mischief award", 150);

    private final String title;
    private final String description;
    private final int triggerPoint;

    Achievements(String title, String description, int triggerPoint)
    {
        this.title = title;
        this.description = description;
        this.triggerPoint = triggerPoint;
    }
}
