package com.gitgudgang.dogeverse.api;

import com.gitgudgang.dogeverse.domain.Dog;
import com.gitgudgang.dogeverse.dto.AchievementDto;
import com.gitgudgang.dogeverse.dto.DogDto;
import com.gitgudgang.dogeverse.entity.AchievementEntity;
import com.gitgudgang.dogeverse.node.AchievementNode;
import com.gitgudgang.dogeverse.service.AchievementService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/achievements")
public class AchievementController {
    
     private AchievementService achievementService;
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    AchievementDto getAchievement(@PathVariable UUID id) {
         return modelMapper.map(achievementService.getAchievement(id), AchievementDto.class);
    }

    @GetMapping("/all")
    List<AchievementDto> getAchievements() {
         return achievementService.getAchievements().stream().map(achievement -> modelMapper.map(achievement, AchievementDto.class)).toList();
    }

    @GetMapping("/read/all")
    List<AchievementDto> getAchievementsRead() {
         return achievementService.getAchievementsRead().stream().map(achievement -> modelMapper.map(achievement, AchievementDto.class)).toList();
    }

    @PostMapping("/success/{id}/{successes}")
    AchievementDto updateAchievement(@PathVariable UUID id, @PathVariable int successes) {
         AchievementNode achievementEntity = achievementService.updateSuccesses(id, successes);
         return modelMapper.map(achievementEntity, AchievementDto.class);
    }

    @GetMapping("/checkAchievements/{id}")
    String checkAchievement(@PathVariable UUID id) {
     String achievementNameOrNull = achievementService.checkAchievementStatus(id, null);
         return achievementNameOrNull;
    }

    @PostMapping("/award/{name}")
    String award(@PathVariable String name) {
         achievementService.awardAchievement(name);;
         return "Congratulations! You are now a "+name;
    }

    private AchievementEntity dtoToAchievement(AchievementDto achievementDto) {
          achievementDto.setId(UUID.randomUUID());
        return modelMapper.map(achievementDto, AchievementEntity.class);
    }
}


