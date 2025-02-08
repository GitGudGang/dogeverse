package com.gitgudgang.dogeverse.Datasources.Primary.models.domain.builder;

import lombok.NoArgsConstructor;

import java.util.List;

import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.DogClass;
import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.TrainerClass;

@NoArgsConstructor
public class TrainerBuilder {
    private TrainerClass trainer;

    public static TrainerBuilder create() {
        var tBuilder = new TrainerBuilder();
        var trainer = new TrainerClass();
        tBuilder.setTrainer(trainer);
        return tBuilder;
    }

    private void setTrainer(TrainerClass trainer) {
        this.trainer = trainer;
    }

    public TrainerBuilder withName(String name) {
        trainer.setName(name);
        return this;
    }

    public TrainerBuilder withStats() {
        this.trainer.setStats(StatFactory.createStats());
        return this;
    }

    public TrainerBuilder withDogs(List<DogClass> dogs) {
        // Bidirectional relationship has to be saved manually
        this.trainer.setDogs(dogs);

        dogs.forEach(dog -> dog.setTrainer(this.trainer));

        return this;
    }

    public TrainerClass build() {
        var temp = trainer;
        trainer = null;
        return temp;
    }
    
}
