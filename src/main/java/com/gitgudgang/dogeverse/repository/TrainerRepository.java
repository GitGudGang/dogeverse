package com.gitgudgang.dogeverse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gitgudgang.dogeverse.entity.TrainerEntity;

import java.util.UUID;

@Repository
public interface TrainerRepository extends CrudRepository<TrainerEntity, UUID>{
    
}
