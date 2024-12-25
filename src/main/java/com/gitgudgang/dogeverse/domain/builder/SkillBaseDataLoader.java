package com.gitgudgang.dogeverse.domain.builder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gitgudgang.dogeverse.domain.SkillBaseData;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class SkillBaseDataLoader {

    public static List<SkillBaseData> loadSkillBaseData() {
        var filePath = "src/main/resources/skill_details.json";
        var mapper = new ObjectMapper();

        try {
            return mapper.readValue(
                    Paths.get(filePath).toFile(),
                    new TypeReference<>() {
                    }
            );
        } catch (IOException e) {
            throw new RuntimeException("Error reading skill details JSON file", e);
        }
    }
}
