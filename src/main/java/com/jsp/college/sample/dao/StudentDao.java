package com.jsp.college.sample.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.college.sample.dto.StudentDto;
import com.jsp.college.sample.repositry.StudentRepository;
@Component
public class StudentDao {
@Autowired
StudentRepository repository;//interface type refernce vareible json object java son object notation postman api download std dao===std service   sevice intermidiate  cotro dao


//EntityManagerFactory emf=Persistence.createEntityManagerFactory(null);
//EntityManager em=emf.createEntityManager();
//void find(){
//	Query q=em.createQuery("select");
//	List<StudentDto> d1= q.getResultList();
//}


public void saveStudent(StudentDto dto) {// cont serv dao==== database  @reqbody===  recive object        takoing info repodstry    @ato creat obj
	repository.save(dto);
	
}
//public void deleteStudent(StudentDto dto){
//	repository.delete(dto);
//}

//option of studentdto   get=====studentdto retun   findbyid  present  in jp reposy=try  d1.ispresent() 

public Optional<StudentDto> fetchById(String email){
	Optional<StudentDto>  d1=repository.findById(email)  ;
//	if(d1.isPresent()){                        
	return d1;

//	}
//		return null;

	}

//public StudentDto fetchById(String email){
//	Optional<StudentDto> d1= repository.findById(email);
//	return d1.get();
//
//}

public List<StudentDto> fetchAll(){
	return repository.findAll();
  }

public StudentDto deleteById(String email) {
	repository.deleteById(email);
	return null;
}
public void deleteAll(){
	 repository.deleteAll();
}
public List<StudentDto> validate(String email,String name){
	   return repository.validate(email, name);
	}
}
