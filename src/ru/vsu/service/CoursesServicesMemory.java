package ru.vsu.service;

import ru.vsu.entities.Course;
import ru.vsu.repository.*;

import java.util.List;
import java.util.Objects;

public class CoursesServicesMemory implements CoursesService {
    private final CoursesRepository coursesRepository;
    private final LecturersRepository lecturersRepository;
    private int ID;
    private static CoursesServicesMemory INSTANCE;

    public static CoursesServicesMemory getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new CoursesServicesMemory();
        }
        return INSTANCE;
    }

    private CoursesServicesMemory(){
        this.ID=0;
        //this.coursesRepository = CoursesMemoryRepository.getInstance();
        this.coursesRepository = CoursesDBRepository.getInstance();
        //this.lecturersRepository = LecturersMemoryRepository.getInstance();
        this.lecturersRepository = LecturersDBRepository.getInstance();
    }

    @Override
    public void updateName(int id, String name) {
        Course course = coursesRepository.getByID(id);
        if(course==null){throw new IllegalArgumentException("Неверный ID курса");}
        coursesRepository.update(id,new Course(id,name,course.getHours()));
    }

    @Override
    public void updateHours(int id, int hours) {
        Course course = coursesRepository.getByID(id);
        if(course==null){throw new IllegalArgumentException("Неверный ID курса");}
        coursesRepository.update(id,new Course(id,course.getName(),hours));
    }

    @Override
    public List<Course> getAll() {
        return coursesRepository.getAll();
    }

    @Override
    public Course getByID(int id) {
        Course course = coursesRepository.getByID(id);
        if(course==null){throw new IllegalArgumentException("Неверный ID курса");}
        return course;
    }

    @Override
    public void add(Course course) {
        List<Course> courses = coursesRepository.getAll();
        if (courses.size() != 0 && course.getID() != null) {
            for (Course c : courses) {
                if (Objects.equals(c.getID(), course.getID())) {
                    throw new IllegalArgumentException("Курс с ID " + c.getID() + " уже существует");
                }
            }
        }
        if (course.getID() == null) {
            course.setID(ID++);
            coursesRepository.add(course);
            return;
        }
        coursesRepository.add(course);
    }

    @Override
    public void delete(int id) {
        coursesRepository.delete(id);
    }
}
