package com.gitgudgang.dogeverse.api;

import com.gitgudgang.dogeverse.dto.DogDto;
import com.gitgudgang.dogeverse.dto.DogSkillDto;
import com.gitgudgang.dogeverse.service.DogService;
import com.gitgudgang.dogeverse.service.DogSkillService;
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

    private final DogSkillService dogSkillService;
    private final ModelMapper modelMapper;

    @GetMapping("/")
    List<DogSkillDto> getAllDogSkills() {
        return dogSkillService.getAllDogSkills()
                .stream()
                .map(dogSkill -> modelMapper.map(dogSkill, DogSkillDto.class))
                .toList();
    }
}
