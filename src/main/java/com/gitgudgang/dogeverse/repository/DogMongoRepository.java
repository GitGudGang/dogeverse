package com.gitgudgang.dogeverse.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.gitgudgang.dogeverse.Datasources.Primary.models.document.DogDocument;

@Repository
public interface DogMongoRepository extends MongoRepository<DogDocument, UUID> {
	
	@Query("{name:'?0'}")
	DogDocument findDogByName(String name);
	//man kan også bruge @Query(value="{name:'?0'}", fields="{'_id' : 1}") for kun at få 'id'
	@Query(value="{breed:'?0'}")
	List<DogDocument> findAllByBreed(String breed);
}	

