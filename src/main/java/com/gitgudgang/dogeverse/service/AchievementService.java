package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.domain.Skill;
import com.gitgudgang.dogeverse.entity.AchievementAdminEntity;
import com.gitgudgang.dogeverse.entity.AchievementEntity;
import com.gitgudgang.dogeverse.entity.AchievementReadOnlyEntity;
import com.gitgudgang.dogeverse.node.AchievementNode;
import com.gitgudgang.dogeverse.repository.AchievementJpaAdminRepository;
import com.gitgudgang.dogeverse.repository.AchievementJpaReadOnlyRepository;
import com.gitgudgang.dogeverse.repository.AchievementNeo4jRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AchievementService {

    private AchievementJpaAdminRepository achievementJpaAdminRepository;
    private AchievementJpaReadOnlyRepository achievementJpaReadOnlyRepository;
    private AchievementNeo4jRepository neo4jRepository;

    public AchievementService(
        AchievementJpaAdminRepository achievementJpaAdminRepository,
        AchievementJpaReadOnlyRepository achievementJpaReadOnlyRepository,
        AchievementNeo4jRepository neo4jRepository
        )
        {
            this.achievementJpaAdminRepository = achievementJpaAdminRepository;
            this.achievementJpaReadOnlyRepository = achievementJpaReadOnlyRepository;
            this.neo4jRepository = neo4jRepository;
        }

    public Iterable<AchievementReadOnlyEntity> getAchievementsReadOnly()
    {
        return achievementJpaReadOnlyRepository.findAll();
    }
    

    public AchievementNode getAchievementNeo4j(UUID id) {
        return neo4jRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Achievement with id " + id + " not found"));
    }

    public AchievementAdminEntity getAchievementMysql(UUID id) {
        return achievementJpaAdminRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Achievement with id " + id + " not found"));
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
