package com.example.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getStudentList() {
		
		return (List<Student>)studentRepository.findAll();
	}

	@Override
	public Student updateStudent(Student student, int id) {
  Student stu=studentRepository.findById(id).get();
  
  if(Objects.nonNull(student.getFirstName())&& !"".equalsIgnoreCase(
			student.getFirstName())) {
		stu.setFirstName(student.getFirstName());
	}
	if(Objects.nonNull(student.getLastName())&& !"".equalsIgnoreCase(
			student.getLastName())) {
		stu.setFirstName(student.getLastName());
	}
	
	if(Objects.nonNull(student.getEmail())&& !"".equalsIgnoreCase(
			student.getEmail())) {
		stu.setFirstName(student.getEmail());
	}
		return studentRepository.save(stu);
	}

	@Override
	public void deleteById(int id) {
		studentRepository.deleteById(id);
		
		
	}
	

}
