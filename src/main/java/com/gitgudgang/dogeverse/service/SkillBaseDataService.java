package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.Datasources.Primary.models.domain.SkillBaseDataClass;
import com.gitgudgang.dogeverse.Datasources.Primary.models.entity.SkillBaseData;
import com.gitgudgang.dogeverse.repository.RepositoryAdapter;
import com.gitgudgang.dogeverse.repository.RepositoryAdapterImpl;
import com.gitgudgang.dogeverse.repository.SkillBaseDataJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SkillBaseDataService {
    private final RepositoryAdapter<SkillBaseDataClass, SkillBaseData, UUID> skillBaseDataJpaRepository;

    public SkillBaseDataService(SkillBaseDataJpaRepository skillBaseDataJpaRepository, ModelMapper modelMapper) {
        this.skillBaseDataJpaRepository = new RepositoryAdapterImpl<>(skillBaseDataJpaRepository,modelMapper, SkillBaseDataClass.class, SkillBaseData.class);
    }

    public SkillBaseDataClass getSkillBaseData(UUID id) {
        return skillBaseDataJpaRepository.findById(id).orElseThrow(EntityNotFoundException::new); //TODO: Make specific exception
    }

    public List<SkillBaseDataClass> getAllSkillBaseData() {
        return StreamSupport.stream(skillBaseDataJpaRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public SkillBaseDataClass saveSkillBaseData(SkillBaseDataClass skillBaseData) {
        return skillBaseDataJpaRepository.save(skillBaseData);
    }

    public Set<SkillBaseDataClass> saveAllSkillBaseData(Iterable<SkillBaseDataClass> skillBaseDatas) {
        skillBaseDatas.forEach(skill -> skill.setId(UUID.randomUUID()));
        var saved = skillBaseDataJpaRepository.saveAll(skillBaseDatas);
        return StreamSupport.stream(saved.spliterator(), false)
                .collect(Collectors.toSet());
    }
}
