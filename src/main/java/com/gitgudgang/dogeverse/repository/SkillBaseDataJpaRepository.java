package com.gitgudgang.dogeverse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gitgudgang.dogeverse.Datasources.Primary.models.entity.SkillBaseData;

import java.util.UUID;

@Repository
public interface SkillBaseDataJpaRepository extends CrudRepository<SkillBaseData, UUID> {
}
