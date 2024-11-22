package com.gitgudgang.dogeverse.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.gitgudgang.dogeverse.entity.mongodb.DogMongo;

@Repository
public interface DogMongoRepository extends MongoRepository<DogMongo, String> {
	
	@Query("{name:'?0'}")
	DogMongo findDogByName(String name);
	//man kan også bruge @Query(value="{name:'?0'}", fields="{'_id' : 1}") for kun at få 'id'
	@Query(value="{breed:'?0'}")
	List<DogMongo> findAllByBreed(String breed);
}	

