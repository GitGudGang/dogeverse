package com.gitgudgang.dogeverse.service;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

// generic counter 

@Service
@AllArgsConstructor
public class CountingService {

    private int counter_int = 0;

    public int incrementCountInt()
    {
        counter_int++;
        return counter_int;
    }
    
}
