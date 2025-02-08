package com.gitgudgang.dogeverse.Datasources.Primary.models.domain.builder;

import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.AttackTypeClass;
import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.DogClass;
import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.StatClass;
import com.gitgudgang.dogeverse.Datasources.Primary.models.entity.Dog;

import lombok.NoArgsConstructor;

import java.util.Random;
import java.util.Set;

@NoArgsConstructor
public class DogBuilder {
// The builder can be used for making testing objects
    private DogClass dog;

    public static DogBuilder create() {
        var dBuilder = new DogBuilder();
        var dog = new DogClass();
        dBuilder.setDog(dog);
        return dBuilder;
    }
    private void setDog(DogClass dog) {
        this.dog = dog;
    }

    public DogBuilder withName(String name) {
        this.dog.setName(name);
        return this;
    }

    public DogBuilder withBreed(String breed) {
        this.dog.setBreed(breed);
        return this;
    }

    public DogBuilder withStats() {
        this.dog.setStats(StatFactory.createStats());
        return this;
    }

    public DogClass build() {
        var temp = dog;
        dog = null;
        return temp;
    }
}
