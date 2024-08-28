package com.example.springboot.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)//Moi lan goi bean nay se tao moi 1 bean moi khac
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Tennis";
    }
}
