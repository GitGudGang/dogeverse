package com.gitgudgang.dogeverse.repository;

import java.util.List;
import java.util.UUID;

import com.gitgudgang.dogeverse.document.DogDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DogMongoRepository extends MongoRepository<DogDocument, UUID> {
	
	@Query("{name:'?0'}")
	DogDocument findDogByName(String name);

	@Query(value="{breed:'?0'}")
	List<DogDocument> findAllByBreed(String breed);
}	

