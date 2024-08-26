package com.example.springboot;

import org.springframework.stereotype.Component;

@Component
public class CrocketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Bach dz test";
    }
}
