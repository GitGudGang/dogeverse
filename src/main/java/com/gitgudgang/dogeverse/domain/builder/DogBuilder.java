package com.gitgudgang.dogeverse.domain.builder;

import com.gitgudgang.dogeverse.domain.Dog;
import com.gitgudgang.dogeverse.domain.Stat;
import com.gitgudgang.dogeverse.domain.StatType;
import com.gitgudgang.dogeverse.entity.DogEntity;
import lombok.NoArgsConstructor;

import java.util.Random;
import java.util.Set;

@NoArgsConstructor
public class DogBuilder {
// The builder can be used for making testing objects
    private Dog dog;

    public static DogBuilder create() {
        var dBuilder = new DogBuilder();
        var dog = new Dog();
        dBuilder.setDog(dog);
        return dBuilder;
    }
    private void setDog(Dog dog) {
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

    public Dog build() {
        var temp = dog;
        dog = null;
        return temp;
    }
}
