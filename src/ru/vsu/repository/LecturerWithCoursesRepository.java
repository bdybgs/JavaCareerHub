package ru.vsu.repository;

import ru.vsu.entities.LecturerWithCourse;

import java.util.List;

public interface LecturerWithCoursesRepository extends Repository<LecturerWithCourse>{
    List<LecturerWithCourse> getAll();
    LecturerWithCourse getByID(int idL,int idC);
    void add(LecturerWithCourse lecturerWithCourse);
    void delete(int idL,int idC);
}