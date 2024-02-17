package ru.vsu.repository;

import ru.vsu.entities.Lecturer;

import java.util.ArrayList;
import java.util.List;

public class LecturersMemoryRepository implements LecturersRepository{
    private final List<Lecturer> lecturers;
    private static LecturersMemoryRepository INSTANCE;
    private LecturersMemoryRepository(){this.lecturers = new ArrayList<>();}

    public static LecturersMemoryRepository getInstance(){
        if(INSTANCE == null){
            INSTANCE = new LecturersMemoryRepository();
        }
        return INSTANCE;
    }



    @Override
    public List<Lecturer> getAll() {
        return new ArrayList<>(lecturers);
    }

    @Override
    public Lecturer getByID(int id) {
        for (Lecturer lecturer : lecturers) {
            if (id == lecturer.getID())
                return lecturer;
        }
        return null;
    }

    @Override
    public void add(Lecturer lecturer) {
        lecturers.add(lecturer);
    }

    @Override
    public void delete(int id) {
        lecturers.removeIf(lecturer -> id == lecturer.getID());
    }

    @Override
    public void update(int id, Lecturer newLecturer) {
        for (Lecturer lecturer : lecturers) {
            if (id == lecturer.getID()) {
                lecturers.remove(lecturer);
                lecturers.add(newLecturer);
                return;
            }
        }
        throw new IllegalArgumentException("Преподавателя с ID " + id + " не существует");
    }
}
