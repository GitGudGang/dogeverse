package com.gitgudgang.dogeverse.repository;


import com.gitgudgang.dogeverse.entity.AchievementEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementMysqlRepository extends CrudRepository<AchievementEntity, UUID> {
    
}

