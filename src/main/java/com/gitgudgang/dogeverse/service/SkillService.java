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
    private final RepositoryAdapter<Skill, SkillEntity, UUID> dogSkillJpaRepository;

    public SkillService(SkillJpaRepository skillJpaRepository, ModelMapper modelMapper) {
        this.dogSkillJpaRepository = new RepositoryAdapterImpl<>(skillJpaRepository, modelMapper, Skill.class, SkillEntity.class);
    }

    public List<Skill> getAllDogSkills() {
        return StreamSupport.stream(dogSkillJpaRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    Skill createAndSaveDogSkill(Dog dog, SkillBaseData skillBaseData, int statValue) {
        var skill = new Skill(UUID.randomUUID(), dog, skillBaseData, statValue, 0, 0);
        return dogSkillJpaRepository.save(skill);
    }
}
