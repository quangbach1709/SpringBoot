package com.example.springboot.rest;

public class StudentNotFoundException extends RuntimeException {// ke thua tu RuntimeException de co the xu ly exception trong controller

    public StudentNotFoundException(String message) {// constructor voi tham so la message de co the hien thi message khi exception xay ra
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {// constructor voi 2 tham so de co the hien thi message va cause khi exception xay ra
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {// constructor voi 1 tham so de co the hien thi cause khi exception xay ra
        super(cause);
    }
}
