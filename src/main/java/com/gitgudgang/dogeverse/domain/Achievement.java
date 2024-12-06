package com.gitgudgang.dogeverse.domain;

import java.util.UUID;

public class Achievement {
    private UUID id;
    private String name;
    private int successes;
    private final int basic = 50;
    private final int intermediate = 100;
    private final int advanced = 150;
    private String description;
}
