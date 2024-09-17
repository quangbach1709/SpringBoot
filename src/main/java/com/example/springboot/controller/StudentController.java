package com.example.springboot.controller;

import com.example.springboot.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        // create a student object

        //add student object to the model
        theModel.addAttribute("student", new Student());

        // add the country options to the model
        theModel.addAttribute("countries", countries);

        //add the language options to the model
        theModel.addAttribute("languages", languages);

        //add the system options to the model
        theModel.addAttribute("systems", systems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {
        // @ModelAttribute("student") Student theStudent la: lay du lieu tu form gui len va gan vao doi tuong theStudent
        // log the input data
        System.out.println("theStudent: " + theStudent.getFirstName()
                + " " + theStudent.getLastName());
        return "student-confirmation";
    }
}
