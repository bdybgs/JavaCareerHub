package ru.vsu.repository;

import ru.vsu.entities.Course;

import java.util.ArrayList;
import java.util.List;

public class CoursesMemoryRepository implements CoursesRepository{
    private final List<Course> courses;
    private static CoursesMemoryRepository INSTANCE;
    private CoursesMemoryRepository(){this.courses = new ArrayList<>();}

    public static CoursesMemoryRepository getInstance(){
        if(INSTANCE == null){
            INSTANCE = new CoursesMemoryRepository();
        }
        return INSTANCE;
    }

    @Override
    public List<Course> getAll() {
        return new ArrayList<>(courses);
    }

    @Override
    public Course getByID(int id) {
        for (Course course : courses) {
            if (id == course.getID())
                return course;
        }
        return null;
    }

    @Override
    public void add(Course course) {
        courses.add(course);
    }

    @Override
    public void delete(int id) {courses.removeIf(course -> id == course.getID());}

    @Override
    public void update(int id, Course newCourse) {
        for (Course course : courses) {
            if (id == course.getID()) {
                courses.remove(course);
                courses.add(newCourse);
                return;
            }
        }
        throw new IllegalArgumentException("Курса с ID " + id + " не существует");
    }
}
