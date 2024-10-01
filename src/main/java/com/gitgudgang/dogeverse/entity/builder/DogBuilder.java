package com.gitgudgang.dogeverse.entity.builder;

import com.gitgudgang.dogeverse.entity.Dog;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DogBuilder {

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

    public Dog build() {
        var temp = dog;
        dog = null;
        return temp;
    }
}
