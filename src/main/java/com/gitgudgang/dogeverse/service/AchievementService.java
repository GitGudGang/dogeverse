package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.AchievementReadRepo.AchievementReadMysqlRepository;
import com.gitgudgang.dogeverse.domain.Achievement;
import com.gitgudgang.dogeverse.domain.Skill;
import com.gitgudgang.dogeverse.entity.AchievementEntity;
import com.gitgudgang.dogeverse.node.AchievementNode;
import com.gitgudgang.dogeverse.repository.AchievementMysqlRepository;
import com.gitgudgang.dogeverse.repository.AchievementNeo4jRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AchievementService {

    private AchievementMysqlRepository mysqlRepository;
    private AchievementReadMysqlRepository mysqlReadRepository;
    private AchievementNeo4jRepository neo4jRepository;

    public AchievementService(
        AchievementMysqlRepository mysqlRepository,
        AchievementReadMysqlRepository mysqlReadRepository,
        AchievementNeo4jRepository neo4jRepository
        )
        {
            this.mysqlRepository = mysqlRepository;
            this.mysqlReadRepository = mysqlReadRepository;
            this.neo4jRepository = neo4jRepository;
        }

        public AchievementEntity getAchievement(UUID id)
        {
            return mysqlRepository.findById(id).get();
        } 
        public List<AchievementEntity> getAchievements()
        {
            return StreamSupport.stream(mysqlRepository.findAll().spliterator(), false)
                    .collect(Collectors.toList());
        } 

    public List<AchievementEntity> getAchievementsRead()
    {
        return StreamSupport.stream(mysqlReadRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    } 

    public AchievementNode getAchievementNeo4j(UUID id) {
        return neo4jRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Achievement with id " + id + " not found"));
    }

   

    public AchievementNode updateSuccesses(UUID id, int successes)
    {

        AchievementNode achievementEntity = neo4jRepository.findById(id).get();
       achievementEntity.setSuccesses(successes);
       neo4jRepository.save(achievementEntity);
        return achievementEntity;
    }

    public String checkAchievementStatus(UUID id, Skill skill)
    {
        AchievementNode achievementEntity = neo4jRepository.findById(id).get();
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
        AchievementNode achievementEntity = new AchievementNode();
        achievementEntity.setName(achievementName);
        neo4jRepository.save(achievementEntity);
        
    }
    
}
