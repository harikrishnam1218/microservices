package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.client.EmployeeClient;
import com.practice.model.Course;

@RestController
@RequestMapping("ribbonfeignclient")
public class RibbonController {
	
	@Autowired
	EmployeeClient employeeClient;

	@GetMapping("")
	public List<Course> getAllCourses() {
		return employeeClient.getAllCourses();
	}

	@GetMapping("/{id}")
	public Course getUserOrdersById(@PathVariable String id) {
		return employeeClient.getCourseById(id);
	}

	@GetMapping("/byRequestParam")
	public List<Course> getUserOrdersByReqParam(@RequestParam String name) {
		return employeeClient.getAllCourseByReqParam(name);
	}

	@GetMapping("/byRequestpostParam")
	public List<Course> testPostWithParam(@RequestParam String name) {
		return employeeClient.getAllCoursesByPostReqParam(name);
	}

	@GetMapping("/byRequestBody")
	public Course testPostWithBody() {
		Course course = new Course();
		course.setId(123l);
		course.setMonths(5);
		course.setName("JAVA");
		course.setDesc("JAVA COURSE");
		return employeeClient.getCourseByPostReqBody(course);

	}

	@GetMapping("/info")
	public String getPortNo() {
		return employeeClient.getPortNo();
	}
}
	
