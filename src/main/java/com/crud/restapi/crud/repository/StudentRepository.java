package com.crud.restapi.crud.repository;

import com.crud.restapi.crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
