package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.domain.Dog;
import com.gitgudgang.dogeverse.domain.Skill;
import com.gitgudgang.dogeverse.domain.SkillBaseData;
import com.gitgudgang.dogeverse.entity.SkillEntity;
import com.gitgudgang.dogeverse.repository.SkillJpaRepository;
import com.gitgudgang.dogeverse.repository.RepositoryAdapter;
import com.gitgudgang.dogeverse.repository.RepositoryAdapterImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SkillService {
    private final RepositoryAdapter<Skill, SkillEntity, UUID> SkillJpaRepository;

    public SkillService(SkillJpaRepository skillJpaRepository, ModelMapper modelMapper) {
        this.SkillJpaRepository = new RepositoryAdapterImpl<>(skillJpaRepository, modelMapper, Skill.class, SkillEntity.class);
    }

    public List<Skill> getAllSkills() {
        return StreamSupport.stream(SkillJpaRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    Skill createAndSaveSkill(Dog dog, SkillBaseData skillBaseData, int statValue) {
        var skill = new Skill(UUID.randomUUID(), dog, skillBaseData, statValue, 0, 0);
        return SkillJpaRepository.save(skill);
    }
}
