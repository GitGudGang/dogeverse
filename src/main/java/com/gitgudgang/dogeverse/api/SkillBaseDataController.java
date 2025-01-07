package com.gitgudgang.dogeverse.api;

import com.gitgudgang.dogeverse.dto.SkillBaseDataDto;
import com.gitgudgang.dogeverse.service.SkillBaseDataService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/skill-base-data")
public class SkillBaseDataController {

    private final SkillBaseDataService skillBaseDataService;
    private final ModelMapper modelMapper;

    @GetMapping("/")
    List<SkillBaseDataDto> getAllSkillBaseData() {
        return skillBaseDataService.getAllSkillBaseData()
                .stream()
                .map(skillBaseData -> modelMapper.map(skillBaseData, SkillBaseDataDto.class))
                .toList();
    }
}
