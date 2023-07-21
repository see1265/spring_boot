

package com.jsp.college.sample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.college.sample.dto.StudentDto;
import com.jsp.college.sample.helper.ResponseStructure;
import com.jsp.college.sample.service.StudentService;
@RestController
@RequestMapping("/students")
public class StudentController 
{

	@Autowired
	StudentService service;
	
	@PostMapping("/save")
	public ResponseStructure<StudentDto> saveStudent(@RequestBody StudentDto dto) { //follow some rules restAPI
	ResponseStructure<StudentDto> rs=service.saveStudent(dto);	
	return rs;
	}
	
//	@PostMapping("/save")
//	public ResponseStructure<StudentDto> saveStudent(@RequestBody StudentDto dto) { //follow some rules restAPI
//	service.saveStudent(dto);	
//	return "saved";
//	}
	
//	@DeleteMapping("/delete")
//	public void deleteStudent(@RequestBody StudentDto dto) {
//		service.deleteStudent(dto);

	@DeleteMapping("delete/{email}")
	public ResponseStructure<StudentDto> deleteById(@PathVariable String email)
	{
		return service.deleteById(email);
	}
	
	@DeleteMapping("/deleteall")
	public ResponseStructure<StudentDto> deleteAll(){
		ResponseStructure<StudentDto> rs=service.deleteAll();	
		return rs;
	}
	
	
	@PutMapping("/update")
	public void updateStudent() {
	
	}
//	@GetMapping("/fetch/{email}")
//	public Object fetchStudent(@PathVariable String email ) {
//		//System.out.println(email);
//	Object o1=service.fetchById(email);
//	return o1;
//	}
	
//	@GetMapping("/fetch")
//	public ResponseStructure<StudentDto> fetchById(@RequestParam String email)
//	{
//	   return service.fetchById(email); 
//	}
	
	@GetMapping("/fetch/{email}")
	public ResponseStructure<StudentDto> fetchStudent(String email ) {
		ResponseStructure<StudentDto>o1=service.fetchById(email); 
		return o1;
	}
	
	@GetMapping("/fatchall")
	public ResponseStructure<List<StudentDto>> fetchall()
	{
		return service.fetchAll();
		
	}
	@PostMapping("/login")
	public List<StudentDto> validate(@RequestBody StudentDto dto){
		return service.validate(dto.getEmail(), dto.getName());
	}
 }
