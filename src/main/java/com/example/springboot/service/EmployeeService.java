package com.example.springboot.service;

import com.example.springboot.entity.Employee;

import java.util.List;

public interface EmployeeService {// khai bao cac phuong thuc can thuc thi

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
