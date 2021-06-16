package com.web;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
@Autowired	
StudentRepository s1;

// get all the details of students
@RequestMapping("/showStudents")
public List<Student> getAllDetails()
{
	List<Student> l1 = new ArrayList<>();
	s1.findAll().forEach(l1::add);
	return l1;
}

// get detail by id
@RequestMapping("/student/{id}")
public Optional<Student> getById(@PathVariable(value="id") long id)
{
	return Optional.of(s1.findById(id).get());
}

// add a new student's details
@PostMapping("/showStudent")
public void add(  @RequestBody Student s)
{
	s1.save(s);
}

// update a record
@PutMapping("/student")
public void update(@RequestBody Student s)
{
	s1.save(s);
}

// delete a record
@DeleteMapping("/student/{id}")
public void delete(@PathVariable(value="id") long id)
{
	s1.deleteById(id);
}

}
