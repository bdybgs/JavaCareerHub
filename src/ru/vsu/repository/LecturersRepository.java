package ru.vsu.repository;

import ru.vsu.entities.Lecturer;

import java.util.List;

public interface LecturersRepository extends Repository<Lecturer>{
    List<Lecturer> getAll();
    Lecturer getByID(int id);
    void add(Lecturer lecturer);
    void delete(int id);
    void update(int id, Lecturer newLecturer);
}
