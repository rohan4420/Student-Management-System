package com.sts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
