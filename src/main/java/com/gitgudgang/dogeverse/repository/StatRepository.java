package com.gitgudgang.dogeverse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gitgudgang.dogeverse.entity.StatEntity;

@Repository
public interface StatRepository extends CrudRepository<StatEntity, Integer>{
    
}
