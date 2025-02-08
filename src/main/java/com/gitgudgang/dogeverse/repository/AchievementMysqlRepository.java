package com.gitgudgang.dogeverse.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gitgudgang.dogeverse.Datasources.Primary.models.entity.Achievement;

@Repository
public interface AchievementMysqlRepository extends CrudRepository<Achievement,UUID>{
    
}
