package com.gitgudgang.dogeverse.Datasources.Primary.models.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.AttackTypeClass;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("Skill")
public class SkillDocument {
    @Id
    private UUID id;
    private String name;
    private AttackTypeClass statType;
    private String description;
    private int baseValue;
    private int totalValue;
    private int successes;
}
