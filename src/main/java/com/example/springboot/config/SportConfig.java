package com.example.springboot.config;

import com.example.springboot.common.Coach;
import com.example.springboot.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//Dinh nghia bean trong file nay va khong can phai dinh nghia @component o class
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
