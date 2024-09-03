package com.example.springboot.dao;

import com.example.springboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //y nghia cua JpaRepository: JpaRepository la 1 interface cua Spring Data JPA cung cap cac phuong thuc de thao tac voi database nhu CRUD (Create, Read, Update, Delete) ma khong can phai viet code
}
