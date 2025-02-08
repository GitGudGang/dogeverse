package com.gitgudgang.dogeverse.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gitgudgang.dogeverse.Datasources.Primary.models.entity.Trainer;

@Repository
public interface TrainerJpaRepository extends CrudRepository<Trainer, UUID> {
}
