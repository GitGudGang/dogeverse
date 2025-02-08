package com.gitgudgang.dogeverse.AchievementReadRepo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gitgudgang.dogeverse.Datasources.Primary.models.entity.Achievement;

@Repository
public interface AchievementReadMysqlRepository extends CrudRepository<Achievement, UUID> {
    
}
