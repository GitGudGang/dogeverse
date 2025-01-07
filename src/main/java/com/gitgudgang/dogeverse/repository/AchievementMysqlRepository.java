package com.gitgudgang.dogeverse.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gitgudgang.dogeverse.entity.AchievementEntity;

@Repository
public interface AchievementMysqlRepository extends CrudRepository<AchievementEntity,UUID>{
    
}
