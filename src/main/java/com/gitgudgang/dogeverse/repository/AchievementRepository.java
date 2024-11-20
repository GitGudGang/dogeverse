package com.gitgudgang.dogeverse.repository;


import com.gitgudgang.dogeverse.entity.Achievement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementRepository extends CrudRepository<Achievement, Integer> {
    
}
