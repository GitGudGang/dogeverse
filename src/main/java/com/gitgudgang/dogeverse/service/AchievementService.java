package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.entity.Achievement;
import com.gitgudgang.dogeverse.entity.Dog;
import com.gitgudgang.dogeverse.repository.AchievementRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AchievementService {

    private AchievementRepository repository;

    public Achievement getAchievement(int id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Achievement with id " + id + " not found"));
    }

    public Achievement updateSuccesses(int id, int successes)
    {

       Achievement achievement = repository.findById(id).get();
       achievement.setSuccesses(successes);
        repository.save(achievement);
        return achievement;
    }

    public String checkAchievementStatus(int id)
    {
        Achievement achievement = repository.findById(id).get();
        int currentSuccesses = repository.findById(id).get().getSuccesses();

        if(currentSuccesses >= achievement.getBasic() && currentSuccesses < achievement.getIntermediate()) 
        {
            return "Porch Stinker";
        } else if(currentSuccesses >= achievement.getIntermediate() && currentSuccesses < achievement.getAdvanced())
        {
            return "Master Pooper";
        } else if(currentSuccesses >= achievement.getAdvanced())
        {
            return "Life Destroyer";
        }
        
        return "No achievement";
    }

    public void awardAchievement(String achievementName)
    {
        Achievement achievement = new Achievement();
        achievement.setName(achievementName);
        repository.save(achievement);
    }
    
}
