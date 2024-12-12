package com.gitgudgang.dogeverse.repository;

import com.gitgudgang.dogeverse.entity.SkillBaseDataEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SkillBaseDataJpaRepository extends CrudRepository<SkillBaseDataEntity, UUID> {
}
