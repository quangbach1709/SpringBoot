package com.example.springboot.common;

import org.springframework.stereotype.Component;

@Component
public class CrocketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Bach dz test";
    }
}
