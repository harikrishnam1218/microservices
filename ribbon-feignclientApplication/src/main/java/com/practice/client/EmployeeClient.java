package com.practice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.model.Course;

@FeignClient(name="http://COURSEAPPLICATION/courseApplication/courses/")
public interface EmployeeClient {

	@GetMapping("")
	public List<Course> getAllCourses();
	
	@GetMapping("/{id}")
	public Course getCourseById(@PathVariable("id") String id);
	
	@GetMapping("/byRequestParam")
	public List<Course> getAllCourseByReqParam(@RequestParam("name") String name);
	
	@PostMapping(value="/byRequestpostParam",produces="application/json",consumes="application/json")
	public List<Course> getAllCoursesByPostReqParam(@RequestParam("name") String name);
	
	@PostMapping("/byRequestBody")
	public Course getCourseByPostReqBody(@RequestBody Course course);
	
	@GetMapping("/info")
	public String getPortNo();
	
}
