package com.gitgudgang.dogeverse.repository;

import com.gitgudgang.dogeverse.entity.DogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogJpaRepository extends CrudRepository<DogEntity, Integer> {
}
