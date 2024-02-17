package ru.vsu.commands;

import ru.vsu.entities.Course;
import ru.vsu.service.CoursesService;
import ru.vsu.service.CoursesServicesMemory;

import java.util.Scanner;

public class PrintAllCourses implements TestatorCommand {

    private final CoursesService coursesService;
    private static PrintAllCourses INSTANCE;

    public static PrintAllCourses getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new PrintAllCourses();
        }
        return INSTANCE;
    }

    public PrintAllCourses(){
        this.coursesService= CoursesServicesMemory.getINSTANCE();
    }

    @Override
    public void execute(Scanner scanner) {
        for (Course course: coursesService.getAll()){
            System.out.println("ID: " + course.getID()+" Название: "+course.getName()+" Часы: "+course.getHours());
        }
    }

    @Override
    public String printName() {
        return "Вывести все курсы";
    }
}
