package com.gitgudgang.dogeverse.repository;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import com.gitgudgang.dogeverse.entity.AchievementReadOnlyEntity;

public interface AchievementJpaReadOnlyRepository extends CrudRepository<AchievementReadOnlyEntity, UUID>{
    
}
