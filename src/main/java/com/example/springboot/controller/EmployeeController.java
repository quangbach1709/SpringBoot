package com.example.springboot.controller;

import com.example.springboot.entity.Employee;
import com.example.springboot.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;


    public EmployeeController(EmployeeService theemployeeService) {
        this.employeeService = theemployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        //get the employees from db
        List<Employee> listEmployees = employeeService.findAll();

        //add to the spring model
        model.addAttribute("employees", listEmployees);
        return "list-employees";
    }
}
