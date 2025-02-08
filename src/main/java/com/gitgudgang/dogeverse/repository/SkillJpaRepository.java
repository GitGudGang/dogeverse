package com.gitgudgang.dogeverse.repository;

import org.springframework.data.repository.CrudRepository;

import com.gitgudgang.dogeverse.Datasources.Primary.models.entity.Skill;

import java.util.UUID;

public interface SkillJpaRepository extends CrudRepository<Skill, UUID> {
}
