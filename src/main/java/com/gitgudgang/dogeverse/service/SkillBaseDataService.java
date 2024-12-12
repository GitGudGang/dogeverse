package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.domain.SkillBaseData;
import com.gitgudgang.dogeverse.entity.SkillBaseDataEntity;
import com.gitgudgang.dogeverse.repository.RepositoryAdapter;
import com.gitgudgang.dogeverse.repository.RepositoryAdapterImpl;
import com.gitgudgang.dogeverse.repository.SkillBaseDataJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class SkillBaseDataService {
    private final RepositoryAdapter<SkillBaseData, SkillBaseDataEntity, UUID> skillBaseDataJpaRepository;

    public SkillBaseDataService(SkillBaseDataJpaRepository skillBaseDataJpaRepository, ModelMapper modelMapper) {
        this.skillBaseDataJpaRepository = new RepositoryAdapterImpl<>(skillBaseDataJpaRepository,modelMapper, SkillBaseData.class, SkillBaseDataEntity.class);
    }

    public SkillBaseData getSkillBaseData(UUID id) {
        return skillBaseDataJpaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Iterable<SkillBaseData> getAllSkillBaseData() {
        return skillBaseDataJpaRepository.findAll();
    }

    public SkillBaseData saveSkillBaseData(SkillBaseData skillBaseData) {
        return skillBaseDataJpaRepository.save(skillBaseData);
    }

    public Iterable<SkillBaseData> saveAllSkillBaseData(Iterable<SkillBaseData> skillBaseDataCol) {
        skillBaseDataCol.forEach(skill -> skill.setId(UUID.randomUUID()));
        return skillBaseDataJpaRepository.saveAll(skillBaseDataCol);
    }
}
