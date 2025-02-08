package com.gitgudgang.dogeverse.Datasources.Primary.models.domain.builder;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.AttackTypeClass;
import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.StatClass;

public class StatFactory {

    public static List<StatClass> createStats() {
        var rand = new Random();
        var strength = new StatClass(UUID.randomUUID(), AttackTypeClass.STRENGTH, rand.nextInt(1, 7));
        var dexterity = new StatClass(UUID.randomUUID(), AttackTypeClass.DEXTERITY, rand.nextInt(1, 7));
        var intelligence = new StatClass(UUID.randomUUID(), AttackTypeClass.INTELLIGENCE, rand.nextInt(1, 7));
        return List.of(strength, dexterity, intelligence);
    }
}
