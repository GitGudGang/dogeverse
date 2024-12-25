package com.gitgudgang.dogeverse.document;

import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gitgudgang.dogeverse.domain.Stat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Document(collection = "Trainer")
public class TrainerDocument {
  @Id
    private UUID id;
    private String name;
    private Set<Stat> stats; //TODO: Change to StatDocument
    private ArrayList<DogDocument> dogs;
}
