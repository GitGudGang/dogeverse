package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.domain.Skill;
import com.gitgudgang.dogeverse.entity.AchievementEntity;
import com.gitgudgang.dogeverse.repository.AchievementMysqlRepository;
import com.gitgudgang.dogeverse.repository.AchievementNeo4jRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AchievementService {

    private AchievementNeo4jRepository neo4jRepository;
    private AchievementMysqlRepository mysqlRepositoryReadOnly;
    private AchievementMysqlRepository mysqlRepository;

    // public AchievementService() {}

    @Autowired
    public AchievementService(
        @Qualifier("readAccess") AchievementMysqlRepository mysqlRepositoryReadOnly,
        AchievementMysqlRepository mysqlRepository,
        AchievementNeo4jRepository neo4jRepository
        )
        {
            this.mysqlRepositoryReadOnly = mysqlRepositoryReadOnly;
            this.mysqlRepository = mysqlRepository;
            this.neo4jRepository = neo4jRepository;
        }

    public Iterable<AchievementEntity> getAchievementsReadOnly()
    {
        return mysqlRepositoryReadOnly.findAll();
    }
    

    public AchievementEntity getAchievementNeo4j(UUID id) {
        return neo4jRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Achievement with id " + id + " not found"));
    }

    public AchievementEntity getAchievementMysql(UUID id) {
        return mysqlRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Achievement with id " + id + " not found"));
    }

    public AchievementEntity updateSuccesses(UUID id, int successes)
    {

       AchievementEntity achievementEntity = neo4jRepository.findById(id).get();
       achievementEntity.setSuccesses(successes);
       neo4jRepository.save(achievementEntity);
        return achievementEntity;
    }

    public String checkAchievementStatus(UUID id, Skill skill)
    {
        AchievementEntity achievementEntity = neo4jRepository.findById(id).get();
        int currentSuccesses = neo4jRepository.findById(id).get().getSuccesses();

        if(currentSuccesses >= achievementEntity.getBasic() && currentSuccesses < achievementEntity.getIntermediate())
        {
            return "Porch Stinker";
        } else if(currentSuccesses >= achievementEntity.getIntermediate() && currentSuccesses < achievementEntity.getAdvanced())
        {
            return "Master Pooper";
        } else if(currentSuccesses >= achievementEntity.getAdvanced())
        {
            return "Life Destroyer";
        }
        
        return "No achievement";
    }

    public void awardAchievement(String achievementName)
    {
        AchievementEntity achievementEntity = new AchievementEntity();
        achievementEntity.setName(achievementName);
        neo4jRepository.save(achievementEntity);
        
    }
    
}
