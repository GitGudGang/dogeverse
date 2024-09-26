package com.dogo.gitgudgang.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Dog {


    @Id
    @GeneratedValue
    private Long id;

    private String name;

}
