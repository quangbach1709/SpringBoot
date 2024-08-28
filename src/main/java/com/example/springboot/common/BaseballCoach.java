package com.example.springboot.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary //Them do uu tien khi chay chuong trinh
//@Lazy //Khi chay chuong trinh thi khong khoi tao bean nay ngay ma khi goi moi khoi tao
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "BaseBall";
    }
}
