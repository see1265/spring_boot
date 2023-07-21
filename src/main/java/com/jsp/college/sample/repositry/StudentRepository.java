package com.jsp.college.sample.repositry;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.jsp.college.sample.dto.StudentDto;
@Component
public interface StudentRepository extends JpaRepository<StudentDto,String> {

	@Query("select data from StudentDto data where email=:email and name=:name")
	List<StudentDto> validate(String email, String name);
}
