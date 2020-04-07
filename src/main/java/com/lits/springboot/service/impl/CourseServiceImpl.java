package com.lits.springboot.service.impl;

import com.lits.springboot.model.Course;
import com.lits.springboot.model.Teacher;
import com.lits.springboot.repository.CourseRepository;
import com.lits.springboot.repository.TeacherRepository;
import com.lits.springboot.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public CourseServiceImpl(CourseRepository courseRepository, TeacherRepository teacherRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Course create(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getOne(Integer id) {
        return courseRepository.findOneById(id);
    }

    @Override
    public Course update(Integer id, String newCourseName, Teacher newTeacher) {
        Course course = courseRepository.findOneById(id);
        course.setCourseName(newCourseName);
        return courseRepository.save(course);
    }

    @Override
    public void delete(Integer id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public List<String> getAllCoursesWithoutTeacher() {
        return null;
    }

    @Override
    public Course updateCourseTeacher(Integer courseId, Integer teacherId) {
        return null;
    }

    @Override
    public Course addTeachersToCourse(Integer courseId, List<Teacher> teachers) {
        Course course = courseRepository.findOneById(courseId);
        course.setTeacherList(teachers);
        return courseRepository.save(course);
    }

}
