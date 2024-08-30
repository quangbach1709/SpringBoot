package com.example.springboot.dao;

import com.example.springboot.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);//save the student

    Student findById(Integer id);
}

