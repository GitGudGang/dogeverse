package com.gitgudgang.dogeverse.repository;


import com.gitgudgang.dogeverse.entity.AchievementEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementRepository extends CrudRepository<AchievementEntity, Integer> {
    
}
