package com.example.springboot.dao;

import com.example.springboot.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    //define the fields for entity manager
    private EntityManager entityManager;

    //injacet the entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement the save method
    @Override
    @Transactional //can them khi thay doi du lieu trong database
    public void save(Student theStudent) {
        entityManager.persist(theStudent);//save or update the student object vao database
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);//return the student object with the given id or null if not found
    }

    @Override
    public List<Student> findAll() {
        //create a query tao ra mot cau truy van
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student order by  lastName asc ", Student.class);//asc: tang dan, desc: giam dan
        //return the result list tra ve danh sach ket qua
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        //create a query tao ra mot cau truy van
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student where lastName=:theData", Student.class);
        //set the parameter dat tham so
        theQuery.setParameter("theData", theLastName);
        //return the result list tra ve danh sach ket qua
        return theQuery.getResultList();
    }

    @Override
    @Transactional //can them khi thay doi du lieu trong database
    public void update(Student theStudent) {
        entityManager.merge(theStudent);//save or update the student object vao database
    }
}
