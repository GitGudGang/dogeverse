package com.gitgudgang.dogeverse.api;

import com.gitgudgang.dogeverse.dto.SkillDto;
import com.gitgudgang.dogeverse.service.SkillService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private final SkillService skillService;
    private final ModelMapper modelMapper;

    @GetMapping("/")
    List<SkillDto> getAllDogSkills() {
        return skillService.getAllDogSkills()
                .stream()
                .map(dogSkill -> modelMapper.map(dogSkill, SkillDto.class))
                .toList();
    }
}
