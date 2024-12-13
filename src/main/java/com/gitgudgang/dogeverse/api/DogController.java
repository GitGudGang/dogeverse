package com.gitgudgang.dogeverse.api;

import com.gitgudgang.dogeverse.domain.Dog;
import com.gitgudgang.dogeverse.dto.DogDto;
import com.gitgudgang.dogeverse.dto.DogSkillDto;
import com.gitgudgang.dogeverse.service.DogService;

import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/dogs")
@AllArgsConstructor
public class DogController {

    private final DogService dogService;
    private final ModelMapper modelMapper;

    @GetMapping("/{id}")
    public DogDto getDog(@PathVariable UUID id) {
        return modelMapper.map(dogService.getDog(id), DogDto.class);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public DogDto createDog(@RequestBody DogDto dogDto) {
        var savedDog = dogService.saveDog(dtoToDog(dogDto));
        return dogToDto(savedDog);
    }

    @PutMapping("/{id}/edit")
    DogDto editDog(@PathVariable UUID id, @RequestBody DogDto dogDto) {
       var editedDog = dogService.editDog(id, dtoToDog(dogDto));
       return dogToDto(editedDog);
    }

    @DeleteMapping("/{id}/delete")
    void deleteDog(@PathVariable UUID id) {
        dogService.deleteDogById(id);
    }

    @DeleteMapping("/delete")
    void deleteDog(@RequestBody DogDto dogDto) {
        dogService.deleteDog(dtoToDog(dogDto));
    }

    //add skill to dog
    @PostMapping("/{id}/add-skill/{skillBaseDataId}")
    DogSkillDto addSkillToDog(@PathVariable UUID id, @PathVariable UUID skillBaseDataId) {
        var savedDogSkill = dogService.addSkillToDog(id, skillBaseDataId);
        return modelMapper.map(savedDogSkill, DogSkillDto.class);
    }

    private Dog dtoToDog(DogDto dto) {
        return modelMapper.map(dto, Dog.class);
    }

    private DogDto dogToDto(Dog dog) {
        return modelMapper.map(dog, DogDto.class);
    }
}