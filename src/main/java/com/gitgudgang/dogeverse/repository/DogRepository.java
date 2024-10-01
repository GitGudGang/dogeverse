package com.gitgudgang.dogeverse.repository;

import com.gitgudgang.dogeverse.entity.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends CrudRepository<Dog, Integer> {
}
