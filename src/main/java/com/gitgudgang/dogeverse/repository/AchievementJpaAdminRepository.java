package com.gitgudgang.dogeverse.repository;


import com.gitgudgang.dogeverse.entity.AchievementAdminEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementJpaAdminRepository extends CrudRepository<AchievementAdminEntity, UUID> {
    
}

