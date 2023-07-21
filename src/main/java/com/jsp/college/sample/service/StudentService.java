package com.jsp.college.sample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jsp.college.sample.dao.StudentDao;
import com.jsp.college.sample.dto.StudentDto;
import com.jsp.college.sample.exceptionhandling.UserDefinedException;
import com.jsp.college.sample.helper.ResponseStructure;

@Service
public class StudentService 
{
@Autowired
StudentDao dao;
//clic + simblo ===post next body== row == json {"email":"abc@gmail.com", //"name":"abc",
//"web_mock":"1"}
 public ResponseStructure<StudentDto> saveStudent(StudentDto dto) {
	 dao.saveStudent(dto);                
	 ResponseStructure<StudentDto> responce=new  ResponseStructure<StudentDto>();                                                       
	 responce.setMessage("saved succusefully");  
	 responce.setStatus(HttpStatus.CREATED.value());
	 responce.setData(dto);
	 return responce;
       }
// public Object fetchById(String email){
//	Object o1= dao.fetchById(email);
//	return o1; 
//}

 public ResponseStructure<StudentDto> fetchById(String email)  {
      Optional<StudentDto> student= dao.fetchById(email);
	 if(student.isPresent())
	 {
		 ResponseStructure<StudentDto> responseStructure= new ResponseStructure<>();
		 responseStructure.setMessage("fetched");
		 responseStructure.setStatus(HttpStatus.FOUND.value());
		 responseStructure.setData(student.get());
		 return responseStructure;
	 }
	 else{
		 throw new UserDefinedException("No such Element Found");
	 }
 }  
 
      
//	 if(student!=null){
//		 ResponseStructure<StudentDto> responce=new  ResponseStructure<>(); 
//		 responce.setMessage("no data found");
//		 responce.setStatus(HttpStatus.FOUND.value());
//		 responce.setData(student);
//		 return responce; 
//	 }else{
//	
//		 ResponseStructure<StudentDto> responce=new  ResponseStructure<>(); 
//		 responce.setMessage("data found");
//		 responce.setStatus(HttpStatus.NOT_FOUND.value());
//		 responce.setData(null);
//		 return responce; 
//	 
//	 }
 
 
 public ResponseStructure<List<StudentDto>>  fetchAll(){
	 List<StudentDto> list=dao.fetchAll();
	 ResponseStructure<List<StudentDto>> responce=new  ResponseStructure<>(); 
	 if(list.isEmpty()){
		 responce.setMessage("no data found");
		 responce.setStatus(HttpStatus.NOT_FOUND.value());
	 }else{
		 responce.setMessage("data found");
		 responce.setStatus(HttpStatus.FOUND.value());
		 responce.setData(list);
	 }
	return responce; 
 }
 
 
//public void deleteStudent(StudentDto dto) {
//	 dao.deleteStudent(dto); 
//     }

public ResponseStructure<StudentDto> deleteAll(){
	dao.deleteAll();  
	 ResponseStructure<StudentDto> responce=new  ResponseStructure<StudentDto>();                                                       
	 responce.setMessage("delete succusefully");  
	 responce.setStatus(HttpStatus.FOUND.value());
	 
	 return responce;
       }


public ResponseStructure<StudentDto> deleteById(String email) {
	StudentDto s = dao.deleteById(email);
	ResponseStructure<StudentDto> responce = new ResponseStructure<>();
	if (s == null) {
		responce.setMessage("No Data Found");
		responce.setStatus(HttpStatus.NOT_FOUND.value());
	} else {
		dao.deleteById(email);
		responce.setMessage("Data Found");
		responce.setStatus(HttpStatus.FOUND.value());
		responce.setData(s);
	}

	return responce;
}
    public List<StudentDto> validate(String email, String name){
    	return dao.validate(email, name);
    }

   }












