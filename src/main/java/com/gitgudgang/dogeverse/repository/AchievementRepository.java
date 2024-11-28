package com.gitgudgang.dogeverse.repository;


import com.gitgudgang.dogeverse.entity.AchievementEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AchievementRepository extends CrudRepository<AchievementEntity, UUID> {
    
}
