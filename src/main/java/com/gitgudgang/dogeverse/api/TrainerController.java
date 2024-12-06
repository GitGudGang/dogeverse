package com.gitgudgang.dogeverse.api;

import java.util.List;
import java.util.UUID;

import com.gitgudgang.dogeverse.domain.Dog;
import com.gitgudgang.dogeverse.dto.DogDto;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gitgudgang.dogeverse.domain.Trainer;
import com.gitgudgang.dogeverse.dto.TrainerDto;
import com.gitgudgang.dogeverse.service.TrainerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/trainers")
@AllArgsConstructor
public class TrainerController {

    private final TrainerService trainerService;
    private final ModelMapper modelMapper;

    @GetMapping("/{id}")
    public TrainerDto getTrainer(@PathVariable UUID id) {
        return modelMapper.map(trainerService.getTrainer(id), TrainerDto.class);
    }

    @GetMapping
    public List<TrainerDto> getAllTrainers() {
        return trainerService.getAllTrainers()
                             .stream()
                             .map(trainer -> modelMapper.map(trainer, TrainerDto.class))
                             .toList();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public TrainerDto createTrainer(@RequestBody TrainerDto trainerDto) {
        var savedTrainer = trainerService.createTrainer(dtoToTrainer(trainerDto));
        return trainerToDto(savedTrainer);
    }

    @PutMapping("/{id}/edit")
    public TrainerDto editTrainer(@PathVariable UUID id, @RequestBody TrainerDto trainerDto) {
        var updatedTrainer = trainerService.updateTrainer(id, dtoToTrainer(trainerDto));
        return trainerToDto(updatedTrainer);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteTrainer(@PathVariable UUID id) {
        trainerService.deleteTrainer(id);
    }

    @PostMapping("/{id}/add-dog/new")
    public TrainerDto addDogToTrainer(@PathVariable UUID id, @RequestBody DogDto dogDto) {
        var updatedTrainer = trainerService.addDogToTrainer(id, modelMapper.map(dogDto, Dog.class));
        return trainerToDto(updatedTrainer);
    }

    private Trainer dtoToTrainer(TrainerDto dto) {
        return modelMapper.map(dto, Trainer.class);
    }

    private TrainerDto trainerToDto(Trainer trainer) {
        return modelMapper.map(trainer, TrainerDto.class);
    }
}
