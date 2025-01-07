package com.gitgudgang.dogeverse.config;

import com.gitgudgang.dogeverse.document.SkillDocument;
import com.gitgudgang.dogeverse.domain.Skill;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(Skill.class, SkillDocument.class)
                .addMapping(src -> src.getDog().getId(), SkillDocument::setDogId);

        return modelMapper;
    }
}
