package com.example.springboot.dao;

import com.example.springboot.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);//save the student

    Student findById(Integer id);//tim kiem student dua tren id

    List<Student> findAll();//lay tat ca student

    List<Student> findByLastName(String theLastName);//tim kiem student dua tren ten ho

    void update(Student theStudent);//cap nhat student

    void delete(Integer id);//xoa student dua tren id
}

