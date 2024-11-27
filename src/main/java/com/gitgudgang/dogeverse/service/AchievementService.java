package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.entity.AchievementEntity;
import com.gitgudgang.dogeverse.repository.AchievementRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AchievementService {

    private AchievementRepository repository;

    public AchievementEntity getAchievement(int id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Achievement with id " + id + " not found"));
    }

    public AchievementEntity updateSuccesses(int id, int successes)
    {

       AchievementEntity achievementEntity = repository.findById(id).get();
       achievementEntity.setSuccesses(successes);
        repository.save(achievementEntity);
        return achievementEntity;
    }

    public String checkAchievementStatus(int id)
    {
        AchievementEntity achievementEntity = repository.findById(id).get();
        int currentSuccesses = repository.findById(id).get().getSuccesses();

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
        repository.save(achievementEntity);
    }
    
}
