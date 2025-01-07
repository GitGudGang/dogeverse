package com.gitgudgang.dogeverse.api;

import com.gitgudgang.dogeverse.domain.Dog;
import com.gitgudgang.dogeverse.dto.DogDto;
import com.gitgudgang.dogeverse.dto.SkillDto;
import com.gitgudgang.dogeverse.service.DogService;

import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/dogs")
public class DogController {

    private final DogService dogService;
    private final ModelMapper modelMapper;

    @GetMapping("/")
    List<DogDto> getAllDogs() {
        return dogService.getAllDogs()
                .stream()
                .map(dog -> modelMapper.map(dog, DogDto.class))
                .toList();
    }

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

    @PutMapping("/{id}")
    DogDto editDog(@PathVariable UUID id, @RequestBody DogDto dogDto) {
       var editedDog = dogService.editDog(id, dtoToDog(dogDto));
       return dogToDto(editedDog);
    }

    @DeleteMapping("/{id}")
    void deleteDog(@PathVariable UUID id) {
        dogService.deleteDogById(id);
    }

    @DeleteMapping("")
    void deleteDog(@RequestBody DogDto dogDto) {
        dogService.deleteDog(dtoToDog(dogDto));
    }

    @PostMapping("/{id}/add-skill/{skillBaseDataId}")
    SkillDto addSkillToDog(@PathVariable UUID id, @PathVariable UUID skillBaseDataId) {
        var savedDogSkill = dogService.addSkillToDog(id, skillBaseDataId);
        return modelMapper.map(savedDogSkill, SkillDto.class);
    }

    private Dog dtoToDog(DogDto dto) {
        return modelMapper.map(dto, Dog.class);
    }

    private DogDto dogToDto(Dog dog) {
        return modelMapper.map(dog, DogDto.class);
    }
}