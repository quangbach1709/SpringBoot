package com.example.springboot.dao;

import com.example.springboot.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);//save the student

    Student findById(Integer id);//tim kiem student dua tren id

    List<Student> findAll();//lay tat ca student
}

