package com.sts.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.entity.Student;
import com.sts.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;
	@Override
	public void saveStudent(Student student) {
		this.studentRepository.save(student);
	}
	@Override
	public List<Student> showList() {
		return studentRepository.findAll();
	}
	@Override
	public void deletestudent(long id) {
		studentRepository.deleteById(id);
	}
	@Override
	public Student updateStudentbyId(long id) {
		Optional <Student> optional = studentRepository.findById(id);
		Student student = null;
		if(optional.isPresent()) {
			student = optional.get();
		}
		else {
			throw new RuntimeException("Data is not present in database");
		}
		return student;
	}

}
