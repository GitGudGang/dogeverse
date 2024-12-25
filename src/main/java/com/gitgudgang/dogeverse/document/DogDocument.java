package com.gitgudgang.dogeverse.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("Dog")
public class DogDocument {
		@Id
		private UUID id;
		private String name;
		private String breed;
		// Could add ref to TrainerDocument, such as ID?
		private List<SkillDocument> skills;
	}
