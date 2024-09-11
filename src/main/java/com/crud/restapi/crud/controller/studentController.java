package com.crud.restapi.crud.controller;

import com.crud.restapi.crud.entity.Student;
import com.crud.restapi.crud.repository.StudentRepository;
import jakarta.persistence.PostRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class studentController {
    // get all the students

    @Autowired
    StudentRepository repo;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> students = repo.findAll();
        return students;
    }


    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        Student student = repo.findById(id).get();
        return  student;
    }

    @PostMapping("/student/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student) {
        repo.save(student);
    }

    @PutMapping("/student/update/{id}")
    public Student updateStudent(@PathVariable int id) {
        Student student = repo.findById(id).get();
        student.setName("Aviee");
        student.setPercentage(92);
        repo.save(student);
        return student;
    }

    @DeleteMapping("/student/delete/{id}")
    public void deleteStudent(@PathVariable int id) {
        repo.deleteById(id);
//
//        Student student = repo.findById(id).get();
//        repo.delete(student);
    }
}
