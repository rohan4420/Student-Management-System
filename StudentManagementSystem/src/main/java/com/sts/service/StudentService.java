package com.sts.service;

import java.util.List;

import com.sts.entity.Student;

public interface StudentService {

   void saveStudent(Student student);
   List<Student> showList();
   void deletestudent(long id);
   public Student updateStudentbyId(long id);

}
