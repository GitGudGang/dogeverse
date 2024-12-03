package com.gitgudgang.dogeverse.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gitgudgang.dogeverse.dto.TrainerDto;
import com.gitgudgang.dogeverse.service.TrainerService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/trainer")
public class TrainerController {
    
    private final TrainerService trainerService;

    @PostMapping
    public ResponseEntity<TrainerDto> createTrainer(@RequestBody TrainerDto trainerDto) {
        TrainerDto createdTrainer = trainerService.createTrainer(trainerDto);
        return ResponseEntity.ok(createdTrainer);
    }

    @GetMapping
    public ResponseEntity<List<TrainerDto>> getAllTrainers() {
        List<TrainerDto> trainers = trainerService.getAllTrainers();
        return ResponseEntity.ok(trainers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainerDto> getTrainerById(@PathVariable String id) {
        TrainerDto trainer = trainerService.getTrainerById(id);
        return ResponseEntity.ok(trainer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainerDto> updateTrainer(
        @PathVariable String id,
        @RequestBody TrainerDto trainerDto
    ) {
        TrainerDto updatedTrainer = trainerService.updateTrainer(id, trainerDto);
        return ResponseEntity.ok(updatedTrainer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainer(@PathVariable String id) {
        trainerService.deleteTrainer(id);
        return ResponseEntity.noContent().build();
    }
}
