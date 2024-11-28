package com.gitgudgang.dogeverse.api;

import com.gitgudgang.dogeverse.dto.AchievementDto;
import com.gitgudgang.dogeverse.entity.AchievementEntity;
import com.gitgudgang.dogeverse.service.AchievementService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/achievements")
public class AchievementController {
    
     private AchievementService achievementService;
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    Achievement getAchievement(@PathVariable int id) {
         return achievementService.getAchievement(id);
    }

    @PostMapping("/success/{id}/{successes}")
    AchievementDto updateAchievement(@PathVariable int id, @PathVariable int successes) {
         AchievementEntity achievementEntity = achievementService.updateSuccesses(id, successes);
         return modelMapper.map(achievementEntity, AchievementDto.class);
    }

    @GetMapping("/checkAchievements/{id}")
    String checkAchievement(@PathVariable int id) {
     String achievementNameOrNull = achievementService.checkAchievementStatus(id);
         return achievementNameOrNull;
    }

    @PostMapping("/award/{name}")
    String award(@PathVariable String name) {
         achievementService.awardAchievement(name);;
         return "Congratulations! You are now a "+name;
    }
}


