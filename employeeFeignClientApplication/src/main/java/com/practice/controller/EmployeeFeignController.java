package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.practice.model.*;

import com.practice.feignClient.EmployeeFeignClient;

@RestController
@RequestMapping("/feigncourses")
public class EmployeeFeignController {
	@Autowired
	EmployeeFeignClient employeeFeignClient;
	
	@GetMapping("")
	public List<Course> fetchAllCouses() {

		return employeeFeignClient.fetchAllCouses();

	}
	
	@GetMapping("/{id}")
	public Course getCourseById(@PathVariable String id) {
		return employeeFeignClient.getAllById(id);
	}
	
	@GetMapping("/byRequestParam")
	public List<Course> getCourseByReqParam(@RequestParam String name) {
		return employeeFeignClient.getAllByReqParam(name);
	}
	
	@GetMapping("/byRequestpostParam")
	public List<Course> testPostWithParam(@RequestParam String name){
		return employeeFeignClient.getAllByPostReqParam(name);
	}
	
	@GetMapping("/byRequestBody")
	public Course testPostWithBody(){
		Course course = new Course();
		course.setId(123l);
		course.setMonths(5);
		course.setName("JAVA");
		course.setDesc("JAVA COURSE");
		return employeeFeignClient.getAllByPostReqBody(course);

}
}
