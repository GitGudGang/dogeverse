package com.gitgudgang.dogeverse.repository;

import com.gitgudgang.dogeverse.entity.DogSkillEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DogSkillJpaRepository extends CrudRepository<DogSkillEntity, UUID> {
}
