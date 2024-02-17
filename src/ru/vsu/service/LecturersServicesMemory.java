package ru.vsu.service;

import ru.vsu.entities.Course;
import ru.vsu.entities.Lecturer;
import ru.vsu.entities.LecturerWithCourse;
import ru.vsu.repository.*;

import java.util.List;
import java.util.Objects;

public class LecturersServicesMemory implements LecturersService {
    private final LecturersRepository lecturersRepository;
    private final CoursesRepository coursesRepository;
    private final LecturerWithCoursesRepository lecturersWithCoursesRepository;
    private static LecturersServicesMemory INSTANCE;
    private int ID;

    public static LecturersServicesMemory getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new LecturersServicesMemory();
        }
        return INSTANCE;
    }

    private LecturersServicesMemory(){
        this.ID = 0;
//        this.lecturersWithCoursesRepository = LecturersWithCoursesMemoryRepository.getInstance();
//        this.coursesRepository = CoursesMemoryRepository.getInstance();
//        this.lecturersRepository = LecturersMemoryRepository.getInstance();
        this.lecturersWithCoursesRepository = LecturersWithCoursesDBRepository.getInstance();
        this.coursesRepository = CoursesDBRepository.getInstance();
        this.lecturersRepository = LecturersDBRepository.getInstance();
    }

    @Override
    public void updateName(int id, String name) {
        Lecturer lecturer = lecturersRepository.getByID(id);
        if (lecturer == null)
            return;
        lecturersRepository.update(id,new Lecturer(id,name,lecturer.getSurname()));
    }

    @Override
    public void updateSurname(int id, String surname) {
        Lecturer lecturer = lecturersRepository.getByID(id);
        if (lecturer == null)
            return;
        lecturersRepository.update(id,new Lecturer(id,lecturer.getName(),surname));
    }

    @Override
    public List<Lecturer> getAll() {
        return lecturersRepository.getAll();
    }

    @Override
    public Lecturer getByID(int id) {
        Lecturer lecturer = lecturersRepository.getByID(id);
        if(lecturer==null){throw new IllegalArgumentException("Неверный ID преподавателя");}
        return lecturer;
    }

//    public Course getCourseByID(int id) {
//        Course course = coursesRepository.getByID(id);
//        if(course==null){throw new IllegalArgumentException("Неверный ID преподавателя");}
//        return course;
//    }

    @Override
    public void add(Lecturer lecturer) {
        List<Lecturer> lecturers = lecturersRepository.getAll();
        if (lecturers.size() != 0 && lecturer.getID() != null) {
            for (Lecturer l : lecturers) {
                if (Objects.equals(l.getID(), lecturer.getID())) {
                    throw new IllegalArgumentException("Преподаватель с ID " + l.getID() + " уже существует");
                }
            }
        }
        if (lecturer.getID() == null) {
            lecturer.setID(ID++);
            lecturersRepository.add(lecturer);
            return;
        }
        lecturersRepository.add(lecturer);
    }


    @Override
    public void delete(int id) {
        if(lecturersRepository.getByID(id)==null){throw new IllegalArgumentException("Неверный ID преподавателя");}
        if(lecturersWithCoursesRepository.getAll()!=null){
        for(LecturerWithCourse lwc : lecturersWithCoursesRepository.getAll()){
            if (lwc.getLecturerId()==id){
                lecturersWithCoursesRepository.delete(id,lwc.getCourseId());
            }
        }}
        lecturersRepository.delete(id);

    }}
