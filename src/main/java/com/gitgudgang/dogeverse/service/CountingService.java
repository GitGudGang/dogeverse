package com.gitgudgang.dogeverse.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

// generic counter 

@Service
@NoArgsConstructor
public class CountingService {

    private int counter= 0;

    public int incrementCountInt()
    {
        counter++;
        return counter;
    }
}
