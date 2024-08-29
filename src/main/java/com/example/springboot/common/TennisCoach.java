package com.example.springboot.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)//Moi lan goi bean nay se tao moi 1 bean moi khac
public class TennisCoach implements Coach {

//    @PostConstruct //Khi khoi tao bean nay xong thi chay ham nay ngay
//    public void doMyStartupStuff() {
//        System.out.println("In doMyStartupStuff " + getClass().getSimpleName());
//    }

//    @PreDestroy //Khi bean nay bi huy thi chay ham nay truoc
//    public void doMyCleanupStuff() {
//        System.out.println("In doMyCleanupStuff " + getClass().getSimpleName());
//    }

    @Override
    public String getDailyWorkout() {
        return "Tennis";
    }
}
