package com.example.springboot.service;


import com.example.springboot.dao.EmployeeRepository;
import com.example.springboot.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // chi ra rang day la 1 bean service cua Spring
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {// thuc thi phuong thuc findAll cua EmployeeRepository interface
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);//y nghia cua Optional: Optional la 1 class trong Java cung cap cac phuong thuc de kiem tra xem 1 doi tuong co null hay khong
        // thuc thi phuong thuc findById cua EmployeeRepository interface de tim kiem 1 employee theo id
        Employee theEmployee;
        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
