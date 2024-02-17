package ru.vsu.repository;

import ru.vsu.entities.Course;

import java.util.List;

public interface CoursesRepository extends Repository<Course>{
    List<Course> getAll();
    Course getByID(int id);
    void add(Course course);
    void delete(int id);
    void update(int id, Course newCourse);
}
