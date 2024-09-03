package com.example.springboot.service;

import com.example.springboot.dao.EmployeeDAO;
import com.example.springboot.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // chi ra rang day la 1 bean service cua Spring
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {// thuc thi phuong thuc findAll cua EmployeeDAO interface
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Transactional
    // chi ra rang day la 1 phuong thuc can duoc quan ly transaction cua Spring can them khi co thay doi du lieu trong database
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Transactional
    // chi ra rang day la 1 phuong thuc can duoc quan ly transaction cua Spring can them khi co thay doi du lieu trong database
    @Override
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}
