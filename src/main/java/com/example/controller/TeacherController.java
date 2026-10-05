package com.example.controller;
import com.example.service.TeacherService;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import com.example.entity.Teacher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;

@RestController
@RequestMapping("/api/teachers")
@CrossOrigin(origins="http://localhost:5173")
public class TeacherController {
	private final TeacherService service;
	
	public TeacherController(TeacherService service) {
		this.service=service;
	}
	
	//getAllTeachers
	@GetMapping
	public List<Teacher>getAllTeachers(){
		return service.getAllTeacher();
	}
	//getById
	@GetMapping("{id}")
	public Teacher getById(@PathVariable Long id) {
		return service.getTeacherById(id);
	}
	//saveTeacher
	@PostMapping
	public Teacher addTeacher(@RequestBody Teacher tea) {
		return service.addTeacher(tea);
	}
	//delete
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}
	//put
	@PutMapping("{id}")
	public Teacher putTeacher(@PathVariable Long id,@RequestBody Teacher tea) {
		return service.updateTeacher(id, tea);
	}
	//patch
	// PATCH
	@PatchMapping("{id}")
	public Teacher patchTeacher(@PathVariable Long id, @RequestBody Teacher tea) {
	    return service.patchTeacher(id, tea);
	}

}
