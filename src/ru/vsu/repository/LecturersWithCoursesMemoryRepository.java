package ru.vsu.repository;

import ru.vsu.entities.Lecturer;
import ru.vsu.entities.LecturerWithCourse;

import java.util.ArrayList;
import java.util.List;

public class LecturersWithCoursesMemoryRepository implements LecturerWithCoursesRepository{
    private final List<LecturerWithCourse> lecturersWithCourse;
    private static LecturersWithCoursesMemoryRepository INSTANCE;
    private LecturersWithCoursesMemoryRepository(){this.lecturersWithCourse = new ArrayList<>();}

    public static LecturersWithCoursesMemoryRepository getInstance(){
        if(INSTANCE == null){
            INSTANCE = new LecturersWithCoursesMemoryRepository();
        }
        return INSTANCE;
    }

    @Override
    public List<LecturerWithCourse> getAll() {
        return new ArrayList<>(lecturersWithCourse);
    }

    @Override
    public LecturerWithCourse getByID(int idL, int idC) {
        for (LecturerWithCourse lecturerWithCourse : lecturersWithCourse) {
            if (idL == lecturerWithCourse.getLecturerId()&&idC==lecturerWithCourse.getCourseId())
                return lecturerWithCourse;
        }
        return null;
    }

    @Override
    public void add(LecturerWithCourse lecturerWithCourse) {
        lecturersWithCourse.add(lecturerWithCourse);
    }

    @Override
    public void delete(int idL, int idC) {
        lecturersWithCourse.removeIf(lecturerWithCourse -> idL == lecturerWithCourse.getLecturerId() && idC == lecturerWithCourse.getCourseId());
    }

}
