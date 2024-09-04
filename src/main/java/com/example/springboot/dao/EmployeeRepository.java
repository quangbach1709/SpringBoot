package com.example.springboot.dao;

import com.example.springboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members") //dung de thay doi ten cua duong dan mac dinh cua REST API
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //y nghia cua JpaRepository: JpaRepository la 1 interface cua Spring Data JPA cung cap cac phuong thuc de thao tac voi database nhu CRUD (Create, Read, Update, Delete) ma khong can phai viet code
}
