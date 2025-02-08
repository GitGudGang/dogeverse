package com.gitgudgang.dogeverse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gitgudgang.dogeverse.Datasources.Primary.models.entity.CharacterStats;

import java.util.UUID;

@Repository
public interface StatRepository extends CrudRepository<CharacterStats, UUID>{
    
}
