package ru.vsu.commands;

import ru.vsu.entities.Course;
import ru.vsu.service.CoursesService;
import ru.vsu.service.CoursesServicesMemory;

import java.util.Scanner;

public class AddCourse implements TestatorCommand{


    private final CoursesService coursesService;
    private static AddCourse INSTANCE;

    public static AddCourse getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new AddCourse();
        }
        return INSTANCE;
    }

    public AddCourse(){
        this.coursesService= CoursesServicesMemory.getINSTANCE();
    }

    @Override
    public void execute(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Название предмета: ");
        String name = scanner.nextLine();
        System.out.println("Количество часов: ");
        int hours = scanner.nextInt();
        coursesService.add(new Course(name,hours));

        //System.out.println(lecturer.getID() + " created");
    }

    @Override
    public String printName() {
        return "Добавить предмет";
    }
}
