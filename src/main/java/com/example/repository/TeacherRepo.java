package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long>{

}
