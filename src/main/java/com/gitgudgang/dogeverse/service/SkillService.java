package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.document.SkillDocument;
import com.gitgudgang.dogeverse.domain.Dog;
import com.gitgudgang.dogeverse.domain.Skill;
import com.gitgudgang.dogeverse.domain.SkillBaseData;
import com.gitgudgang.dogeverse.entity.SkillEntity;
import com.gitgudgang.dogeverse.node.SkillNode;
import com.gitgudgang.dogeverse.repository.*;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SkillService {
    private final RepositoryAdapter<Skill, SkillEntity, UUID> dogSkillJpaRepository;
    private final RepositoryAdapterImpl<Skill, SkillDocument, UUID> skillMongoRepository;
    private final RepositoryAdapterImpl<Skill, SkillNode, UUID> skillNeo4jRepository;

    public SkillService(SkillJpaRepository skillJpaRepository, SkillMongoRepository skillMongoRepository, SkillNeo4jRepository skillNeo4jRepository, ModelMapper modelMapper) {
        this.dogSkillJpaRepository = new RepositoryAdapterImpl<>(skillJpaRepository, modelMapper, Skill.class, SkillEntity.class);
        this.skillMongoRepository = new RepositoryAdapterImpl<>(skillMongoRepository, modelMapper, Skill.class, SkillDocument.class);
        this.skillNeo4jRepository = new RepositoryAdapterImpl<>(skillNeo4jRepository, modelMapper, Skill.class, SkillNode.class);
    }

    public List<Skill> getAllDogSkills() {
        return StreamSupport.stream(dogSkillJpaRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Transactional
    public Skill createAndSaveDogSkill(Dog dog, SkillBaseData skillBaseData, int statValue) {
        var skill = new Skill(UUID.randomUUID(), dog, skillBaseData, statValue, 0, 0);
        saveDogSkill(skill);
        return skill;
    }

    private void saveDogSkill(Skill skill) {
        dogSkillJpaRepository.save(skill);
        skillMongoRepository.save(skill);
        skillNeo4jRepository.save(skill);
    }
}
