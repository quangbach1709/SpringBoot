package com.example.springboot;

import com.example.springboot.dao.StudentDAO;
import com.example.springboot.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication(scanBasePackages = {"com.example.springboot", "util"}) // quet cac tep ngoai pham vi
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            createStudent(studentDAO);
        };

    }

    private void createStudent(StudentDAO studentDAO) {
        //create a student
        System.out.println("Create a new student");
        Student tempStudent = new Student("John", "Doe", "bachh1124@gmail.com");

        //save the student
        System.out.println("Saving the student");
        studentDAO.save(tempStudent);

        //display the id student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());

    }

}
