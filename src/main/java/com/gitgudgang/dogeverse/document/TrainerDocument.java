package com.gitgudgang.dogeverse.document;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gitgudgang.dogeverse.api.StatController;
import com.gitgudgang.dogeverse.entity.DogEntity;

import lombok.Data;

@Data
@Document(collection = "trainers")
public class TrainerDocument {
  @Id
    private UUID id;
    private String name;
    private StatController stats; 
    private ArrayList<DogEntity> dogs;
}
