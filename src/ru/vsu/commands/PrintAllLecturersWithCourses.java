package ru.vsu.commands;

import ru.vsu.entities.Course;
import ru.vsu.entities.Lecturer;
import ru.vsu.entities.LecturerWithCourse;
import ru.vsu.service.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrintAllLecturersWithCourses implements TestatorCommand {

    private final LecturersWithCoursesService lecturersWithCourseService;
    private static PrintAllLecturersWithCourses INSTANCE;

    public static PrintAllLecturersWithCourses getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new PrintAllLecturersWithCourses();
        }
        return INSTANCE;
    }

    public PrintAllLecturersWithCourses(){
        this.lecturersWithCourseService= LecturersWithCoursesServicesMemory.getINSTANCE();
    }

    @Override
    public void execute(Scanner scanner) {
        if (lecturersWithCourseService.getAll()==null||lecturersWithCourseService.getAll().size()==0){
            System.out.println("Отсутствуют преподаватели с курсами");
        }else{
            List<Integer> used= new ArrayList<>();
        for(LecturerWithCourse lwc : lecturersWithCourseService.getAll()){
            int id = lwc.getLecturerId();
            if(!containInt(used,id)) {
                Lecturer lecturer = lecturersWithCourseService.getLecturerByID(lwc.getLecturerId());
                //Course course = lecturersWithCourseService.getCourseByID(lwc.getCourseId());
                lecturersWithCourseService.print(lecturer.getID());
                used.add(id);
            }}}
    }

    private boolean containInt(List<Integer> used, int id){
        for(Integer i : used){
            if(i==id){return true;}
        }
        return false;
    }

    @Override
    public String printName() {
        return "Вывести всех преподавателей с их курсами";
    }
}
