package com.lits.springboot.repository;

import com.lits.springboot.model.Course;
import com.lits.springboot.model.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

    Course findOneById(Integer id);

    List<Course> findAll();

}
