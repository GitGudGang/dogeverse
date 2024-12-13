package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.domain.Dog;
import com.gitgudgang.dogeverse.domain.DogSkill;
import com.gitgudgang.dogeverse.domain.SkillBaseData;
import com.gitgudgang.dogeverse.entity.DogSkillEntity;
import com.gitgudgang.dogeverse.repository.DogSkillJpaRepository;
import com.gitgudgang.dogeverse.repository.RepositoryAdapter;
import com.gitgudgang.dogeverse.repository.RepositoryAdapterImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DogSkillService {
    private final RepositoryAdapter<DogSkill, DogSkillEntity, UUID> dogSkillJpaRepository;

    public DogSkillService(DogSkillJpaRepository dogSkillJpaRepository, ModelMapper modelMapper) {
        this.dogSkillJpaRepository = new RepositoryAdapterImpl<>(dogSkillJpaRepository, modelMapper, DogSkill.class, DogSkillEntity.class);
    }

    DogSkill createAndSaveDogSkill(Dog dog, SkillBaseData skillBaseData, int statValue) {
        var skill = new DogSkill(UUID.randomUUID(), dog, skillBaseData, statValue, 0, 0);
        return dogSkillJpaRepository.save(skill);
    }
}
