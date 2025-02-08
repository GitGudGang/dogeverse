package com.gitgudgang.dogeverse.Datasources.Primary.models.domain;

public enum Breed {

    GOLDEN_RETRIEVER("Golden Retriever"),
    GERMAN_SHEPHERD("German Shepherd"),
    PITBULL("Pitbull");

    private final String name;

    Breed(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
