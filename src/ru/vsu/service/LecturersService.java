package ru.vsu.service;

import ru.vsu.entities.Lecturer;

public interface LecturersService extends Service<Lecturer>{
    void updateName(int id, String name);
    void updateSurname(int id, String surname);
    Lecturer getByID(int id);
    void delete(int id);
}
