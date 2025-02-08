package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.DogClass;
import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.SkillBaseDataClass;
import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.SkillClass;
import com.gitgudgang.dogeverse.Datasources.Primary.models.entity.Skill;
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
    private final RepositoryAdapter<SkillClass, Skill, UUID> dogSkillJpaRepository;

    public SkillService(SkillJpaRepository skillJpaRepository, ModelMapper modelMapper) {
        this.dogSkillJpaRepository = new RepositoryAdapterImpl<>(skillJpaRepository, modelMapper, SkillClass.class, Skill.class);
    }

    public List<SkillClass> getAllDogSkills() {
        return StreamSupport.stream(dogSkillJpaRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    SkillClass createAndSaveDogSkill(DogClass dog, SkillBaseDataClass skillBaseData, int statValue) {
        var skill = new SkillClass(UUID.randomUUID(), dog, skillBaseData, statValue, 0, 0);
        return dogSkillJpaRepository.save(skill);
    }
}
