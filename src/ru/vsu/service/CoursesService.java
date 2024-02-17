package ru.vsu.service;

import ru.vsu.entities.Course;

public interface CoursesService extends Service<Course> {
    void updateName(int id, String name);
    void updateHours(int id, int hours);
    Course getByID(int id);
    void delete(int id);
}
