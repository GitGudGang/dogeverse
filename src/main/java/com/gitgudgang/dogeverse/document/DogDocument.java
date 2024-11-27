package com.gitgudgang.dogeverse.document;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Document("Dog")
public class DogMongo {
		@Id
		private String id;
		private String name;
		private String breed;
	}
