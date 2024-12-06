package com.gitgudgang.dogeverse.domain.builder;

import com.gitgudgang.dogeverse.domain.Stat;
import com.gitgudgang.dogeverse.domain.StatType;

import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class StatFactory {

    public static Set<Stat> createStats() {
        var rand = new Random();
        var strength = new Stat(UUID.randomUUID(), StatType.STRENGTH, rand.nextInt(1, 7));
        var dexterity = new Stat(UUID.randomUUID(), StatType.DEXTERITY, rand.nextInt(1, 7));
        var intelligence = new Stat(UUID.randomUUID(), StatType.INTELLIGENCE, rand.nextInt(1, 7));
        return Set.of(strength, dexterity, intelligence);
    }
}
