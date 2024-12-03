package com.gitgudgang.dogeverse.service;

import com.gitgudgang.dogeverse.document.TrainerDocument;
import com.gitgudgang.dogeverse.dto.TrainerDto;
import com.gitgudgang.dogeverse.repository.TrainerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerDto createTrainer(TrainerDto trainerDto) {
        TrainerDocument trainer = new TrainerDocument();
        trainer.setId(UUID.randomUUID());
        trainer.setName(trainerDto.getName());
        trainer.setStats(trainerDto.getStats());
        trainer.setDogs(trainerDto.getDogs());
        TrainerDocument savedTrainer = trainerRepository.save(trainer);
        return convertToDto(savedTrainer);
    }

    public List<TrainerDto> getAllTrainers() {
        return ((List<TrainerDocument>) trainerRepository.findAll()).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public TrainerDto getTrainerById(String id) {
        TrainerDocument trainer = trainerRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Trainer not found"));
        return convertToDto(trainer);
    }

    public TrainerDto updateTrainer(String id, TrainerDto trainerDto) {
        TrainerDocument trainer = trainerRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Trainer not found"));
        trainer.setName(trainerDto.getName());
        trainer.setStats(trainerDto.getStats());
        trainer.setDogs(trainerDto.getDogs());
        TrainerDocument updatedTrainer = trainerRepository.save(trainer);
        return convertToDto(updatedTrainer);
    }

    public void deleteTrainer(String id) {
        trainerRepository.deleteById(UUID.fromString(id));
    }

    private TrainerDto convertToDto(TrainerDocument trainer) {
        return new TrainerDto(
                trainer.getId(),
                trainer.getName(),
                trainer.getStats(),
                trainer.getDogs()
        );
    }
}
