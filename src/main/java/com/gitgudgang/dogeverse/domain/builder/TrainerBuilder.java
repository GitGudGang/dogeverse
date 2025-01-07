package com.gitgudgang.dogeverse.domain.builder;

import com.gitgudgang.dogeverse.domain.Dog;
import com.gitgudgang.dogeverse.domain.Trainer;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class TrainerBuilder {
    private Trainer trainer;

    public static TrainerBuilder create() {
        var tBuilder = new TrainerBuilder();
        var trainer = new Trainer();
        tBuilder.setTrainer(trainer);
        return tBuilder;
    }

    private void setTrainer(Trainer trainer) {
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

    public TrainerBuilder withDogs(List<Dog> dogs) {
        // Bidirectional relationship has to be saved manually
        this.trainer.setDogs(dogs);

        dogs.forEach(dog -> dog.setTrainer(this.trainer));

        return this;
    }

    public Trainer build() {
        var temp = trainer;
        trainer = null;
        return temp;
    }
    
}
