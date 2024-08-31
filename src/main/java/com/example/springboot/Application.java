package com.example.springboot;

import com.example.springboot.dao.StudentDAO;
import com.example.springboot.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

//@SpringBootApplication(scanBasePackages = {"com.example.springboot", "util"}) // quet cac tep ngoai pham vi
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
//            createMultipleStudents(studentDAO);
//            readStudent(studentDAO);
//            queryForStudent(studentDAO);
//            queryForStudentByLastName(studentDAO);
//            updateStudent(studentDAO);
            deleteStudent(studentDAO);
        };

    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 4;
        System.out.println("Deleting student with id: " + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        //retrieve student based on the id: primary key
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);
        //change first name
        System.out.println("Updating student...");
        myStudent.setFirstName("Scooby");
        //update the student
        studentDAO.update(myStudent);
        //display the student object
        System.out.println("Updated student: " + myStudent);
    }

    private void queryForStudentByLastName(StudentDAO studentDAO) {
        //get a list of students
        List<Student> theStudents = studentDAO.findByLastName("Doe");
        //display the students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void queryForStudent(StudentDAO studentDAO) {
        //get a list of students
        List<Student> theStudents = studentDAO.findAll();
        //display the students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        //create a student object
        System.out.println("Create a new student");
        Student tempStudent = new Student("Daffy", "Duck", "bachdz@gmail.com");
        //save the student object
        System.out.println("Saving the student");
        studentDAO.save(tempStudent);
        //display id the student object
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
        //retrieve student based on the id: primary key
        System.out.println("Getting student with id: " + tempStudent.getId());
        Student myStudent = studentDAO.findById(tempStudent.getId());
        //display the student object
        System.out.println("Found the student: " + myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        //create multiple students
        System.out.println("Create multiple students");
        Student tempStudent1 = new Student("John", "Doe", "bachh1124@gmail.com");
        Student tempStudent2 = new Student("Mary", "Public", "bachh1124@gmail.com");
        Student tempStudent3 = new Student("Bonita", "Applebum", "bachh1124@gmail.com");
        //save the student object
        System.out.println("Saving the students");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
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
