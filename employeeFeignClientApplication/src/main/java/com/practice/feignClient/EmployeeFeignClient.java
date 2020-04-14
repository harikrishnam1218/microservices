package com.practice.feignClient;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.model.Course;

//http://COURSEAPPLICATION/courseApplication/courses/
//@FeignClient(value="employee-application",url="http://localhost:8084/courseApplication/courses/")
@FeignClient(name="http://COURSEAPPLICATION/courseApplication/courses/")
public interface EmployeeFeignClient {

	@GetMapping("")
	public List<Course> fetchAllCouses();
	
	@GetMapping("/{id}")
	public Course getAllById(@PathVariable("id") String id);
	
	@GetMapping("/byRequestParam")
	public List<Course> getAllByReqParam(@RequestParam("name") String name);
	
	@PostMapping("/byRequestpostParam")
	public List<Course> getAllByPostReqParam(@RequestParam("name") String name);
	
	@PostMapping("/byRequestBody")
	public Course getAllByPostReqBody(@RequestBody Course course);
	
	@GetMapping("/{id}")
	public Course getCourseByPathParam(@PathParam("id") String id);
	
	//@GetMapping("/info")
	//public String getPort();
}
