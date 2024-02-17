package ru.vsu.service;

import ru.vsu.ConnectionManager;
import ru.vsu.entities.Course;
import ru.vsu.entities.Lecturer;
import ru.vsu.entities.LecturerWithCourse;
import ru.vsu.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LecturersWithCoursesServicesMemory implements LecturersWithCoursesService{
    private final LecturersRepository lecturersRepository;
    private final CoursesRepository coursesRepository;
    private final LecturerWithCoursesRepository lecturersWithCoursesRepository;
    private static LecturersWithCoursesServicesMemory INSTANCE;
    //private int ID;

    private LecturersWithCoursesServicesMemory(){
//        this.coursesRepository = CoursesMemoryRepository.getInstance();
//        this.lecturersRepository = LecturersMemoryRepository.getInstance();
//        this.lecturersWithCoursesRepository = LecturersWithCoursesMemoryRepository.getInstance();
        this.coursesRepository = CoursesDBRepository.getInstance();
        this.lecturersRepository = LecturersDBRepository.getInstance();
        this.lecturersWithCoursesRepository = LecturersWithCoursesDBRepository.getInstance();
    }

    public static LecturersWithCoursesServicesMemory getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new LecturersWithCoursesServicesMemory();
        }
        return INSTANCE;
    }

    @Override
    public LecturerWithCourse getByID(int idL, int idC) {
        LecturerWithCourse lecturerWithCourse = lecturersWithCoursesRepository.getByID(idL,idC);
        if(lecturerWithCourse==null){throw new IllegalArgumentException("Неверный ID преподавателя с лекцией");}
        return lecturerWithCourse;
    }

    @Override
    public void delete(int idL, int idC) {
        if(lecturersWithCoursesRepository.getByID(idL,idC)==null){throw new IllegalArgumentException("Курса с таким ID нет у данного преподавателя");}
        lecturersWithCoursesRepository.delete(idL,idC);
    }

    @Override
    public Lecturer getLecturerByID(int id) {
        Lecturer lecturer = lecturersRepository.getByID(id);
        if(lecturer==null){throw new IllegalArgumentException("Неверный ID преподавателя");}
        return lecturer;
    }

    @Override
    public Course getCourseByID(int id) {
        Course course = coursesRepository.getByID(id);
        if(course==null){throw new IllegalArgumentException("Неверный ID курса");}
        return course;
    }

    @Override
    public void print(int id) {
        Lecturer lecturer = lecturersRepository.getByID(id);
        List<Course> courses = new ArrayList<>();
        for(LecturerWithCourse lwc : lecturersWithCoursesRepository.getAll()){
            Course course = coursesRepository.getByID(lwc.getCourseId());
            if((lwc.getLecturerId()==id)&&(!containCourse(courses,course))){
                courses.add(course);
            }
        }
        System.out.println("ID: " + lecturer.getID()+" Имя: "+lecturer.getName()+" Фамилия: "+lecturer.getSurname()+" Курсы:"+ courses);

    }

    private boolean containCourse(List<Course> courses, Course course){
        for(Course c : courses){
            if(c.equals(course)){return true;}
        }
        return false;
    }

    @Override
    public List<LecturerWithCourse> getAll() {
        return lecturersWithCoursesRepository.getAll();
    }

    @Override
    public void add(LecturerWithCourse lecturerWithCourse) {
        List<LecturerWithCourse> lecturersWithCourses = lecturersWithCoursesRepository.getAll();
        if(lecturersWithCourses!=null){
        if (lecturersWithCourses.size() != 0 && lecturerWithCourse.getLecturerId() != null && lecturerWithCourse.getCourseId() != null) {
            for (LecturerWithCourse lwc : lecturersWithCourses) {
                if ((Objects.equals(lwc.getCourseId(), lecturerWithCourse.getCourseId()))&&(Objects.equals(lwc.getLecturerId(), lecturerWithCourse.getLecturerId()))) {
                    throw new IllegalArgumentException("Преподаватель с ID " + lwc.getLecturerId() + " уже существует");
                }
            }
        }}
        lecturersWithCoursesRepository.add(lecturerWithCourse);
    }


}
