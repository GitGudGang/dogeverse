package com.gitgudgang.dogeverse.domain.builder;

import com.gitgudgang.dogeverse.domain.Trainer;
import lombok.NoArgsConstructor;

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

    public Trainer build() {
        var temp = trainer;
        trainer = null;
        return temp;
    }
    
}
