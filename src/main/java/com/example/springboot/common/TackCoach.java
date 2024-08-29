package com.example.springboot.common;

import org.springframework.stereotype.Component;

@Component
public class TackCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Track";
    }
}
