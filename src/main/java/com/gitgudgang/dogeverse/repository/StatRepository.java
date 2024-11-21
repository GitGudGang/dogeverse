package com.gitgudgang.dogeverse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gitgudgang.dogeverse.entity.Stat;

@Repository
public interface StatRepository extends CrudRepository<Stat, Integer>{
    
}
