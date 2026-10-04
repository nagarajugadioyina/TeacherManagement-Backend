package com.example.service;
import org.springframework.stereotype.Service;
import com.example.repository.TeacherRepo;
import java.util.List;
import com.example.entity.Teacher;


@Service
public class TeacherService {
	private final TeacherRepo repo;
	
	//constructor dependency injection
	public TeacherService(TeacherRepo repo) {
		this.repo=repo;
	}
	
	//getAllTeachers
	public List<Teacher> getAllTeacher(){
		return repo.findAll();
	}
	
	//getTeacherById
	public Teacher getTeacherById(Long id) {
		return repo.findById(id).orElseThrow(()->new RuntimeException("Teacher not found with ID:"+id));
	}
	//saveTeacher
	public Teacher addTeacher(Teacher tea) {
		return repo.save(tea);
	}
	//deleteTeacherById
	public void deleteById(Long id) {
	    repo.deleteById(id);
	}
	
	
	//updateTeacher
	public Teacher updateTeacher(Long id,Teacher tea) {
		
		Teacher exist=getTeacherById(id);
		
		exist.setName(tea.getName());
		exist.setDept(tea.getDept());
		exist.setSalary(tea.getSalary());
		exist.setExperience(tea.getExperience());		
		
		return repo.save(exist);
	}
	//patchTeacher
	public Teacher patchTeacher(Long id, Teacher tea) {

	    Teacher exist = getTeacherById(id);

	    if (tea.getName() != null) {
	        exist.setName(tea.getName());
	    }

	    if (tea.getDept() != null) {
	        exist.setDept(tea.getDept());
	    }

	    if (tea.getSalary() != null) {
	        exist.setSalary(tea.getSalary());
	    }

	    if (tea.getExperience() != null) {
	        exist.setExperience(tea.getExperience());
	    }

	    return repo.save(exist);
	}
	
	
	

}
