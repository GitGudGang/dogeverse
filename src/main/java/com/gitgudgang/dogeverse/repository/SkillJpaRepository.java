package com.gitgudgang.dogeverse.repository;

import com.gitgudgang.dogeverse.entity.SkillEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SkillJpaRepository extends CrudRepository<SkillEntity, UUID> {
}
