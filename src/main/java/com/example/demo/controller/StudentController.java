package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) {
	  return studentService.saveStudent(student);

}
	@PutMapping("/put")
	public Student updateStudent(@RequestBody Student student,Integer id) {
		return studentService.updateStudent(student, id);
	}
	
	@GetMapping("/get")
	public List<Student> getStudentList(){
		return studentService.getStudentList();
	}
	
	@DeleteMapping("/delete{id}")
	public String deleteStudentById(@PathVariable("id")int id) {
		studentService.deleteById(id);
		return "Deleted";
	}
}
