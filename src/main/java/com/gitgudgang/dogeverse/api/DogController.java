package com.gitgudgang.dogeverse.api;

import com.gitgudgang.dogeverse.domain.Dog;
import com.gitgudgang.dogeverse.dto.DogDto;
import com.gitgudgang.dogeverse.service.DogService;

import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    // @GetMapping("/all")
    // public List<DogDto> getDog() {
        
    //     Iterable<Dog> dogs = dogService.getAllDogs();
           
    //     return StreamSupport.stream(dogs.spliterator(), false)
    //                         .map(dog -> modelMapper.map(dog, DogDto.class))
    //                         .collect(Collectors.toList()); 
    // }

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

    private Dog dtoToDog(DogDto dto) {
        return modelMapper.map(dto, Dog.class);
    }

    private DogDto dogToDto(Dog dog) {
        return modelMapper.map(dog, DogDto.class);
    }
}