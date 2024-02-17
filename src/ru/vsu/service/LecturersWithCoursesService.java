package ru.vsu.service;

import ru.vsu.entities.Course;
import ru.vsu.entities.Lecturer;
import ru.vsu.entities.LecturerWithCourse;

public interface LecturersWithCoursesService extends Service<LecturerWithCourse>{
    LecturerWithCourse getByID(int idL,int idC);
    void delete(int idL,int idC);
    Lecturer getLecturerByID(int id);
    Course getCourseByID(int id);
    void print(int id);

}
