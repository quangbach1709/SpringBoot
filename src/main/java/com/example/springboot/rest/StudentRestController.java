package com.example.springboot.rest;

import com.example.springboot.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    //define @PostConstruct to load the student data only once
    @PostConstruct // chay sau khi constructor va truoc cac phuong thuc khac
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("John", "Doe"));
        theStudents.add(new Student("Mary", "Public"));
        theStudents.add(new Student("Suzan", "Doe"));
    }

    //define endpoint for "/students" - return list of students
    @GetMapping("/students")
    public List<Student> getStudents() {


        return theStudents;
    }

    //define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {//@PathVariable: lay gia tri tu URL

        //check the studentId against list size
        if ((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }


}
