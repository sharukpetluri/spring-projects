package com.learn.SpringJDBCEx.service;

import com.learn.SpringJDBCEx.model.Student;
import com.learn.SpringJDBCEx.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository repo;

    public StudentRepository getRepo() {
        return repo;
    }
    @Autowired
    public void setRepo(StudentRepository repo) {
        this.repo = repo;
    }

    public void addStudent(Student s) {
        System.out.println("Student added to Service layer");
        repo.save(s);  // again student being added to repository layer
    }

    public List<Student> getStudents() {
        return repo.findAll();
    }
}
