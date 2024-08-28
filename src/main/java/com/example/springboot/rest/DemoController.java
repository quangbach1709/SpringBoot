package com.example.springboot.rest;

import com.example.springboot.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(
            @Qualifier("tennisCoach") Coach theCoach,
            @Qualifier("tennisCoach") Coach theanotherCoach) {
        System.out.println("in constructor: " + getClass().getSimpleName());
        anotherCoach = theanotherCoach;
        myCoach = theCoach;
    }

    @GetMapping("/bach")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Check myCoach == anotherCoach: " + (myCoach == anotherCoach);
    }

}
