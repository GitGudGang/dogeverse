package com.gitgudgang.dogeverse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gitgudgang.dogeverse.entity.StatEntity;

import java.util.UUID;

@Repository
public interface StatRepository extends CrudRepository<StatEntity, UUID>{
    
}
