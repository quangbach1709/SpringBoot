package com.example.springboot.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
    //add exception handling code here
    //add an exception handler using @ExceptionHandler
    @ExceptionHandler // xu ly cac exception trong controller
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {// xu ly exception StudentNotFoundException trong controller nay

        //create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();// tao ra 1 doi tuong StudentErrorResponse
        error.setStatus(HttpStatus.NOT_FOUND.value());// set status
        error.setMessage(exc.getMessage());// set message
        error.setTimeStamp(System.currentTimeMillis());// set timestamp

        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);// tra ve 1 doi tuong ResponseEntity voi status la NOT_FOUND
    }

    //add another exception handler to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {// xu ly cac exception khac trong controller nay

        //create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();// tao ra 1 doi tuong StudentErrorResponse
        error.setStatus(HttpStatus.BAD_REQUEST.value());// set status
        error.setMessage(exc.getMessage());// set message
        error.setTimeStamp(System.currentTimeMillis());// set timestamp

        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);// tra ve 1 doi tuong ResponseEntity voi status la BAD_REQUEST
    }
}
