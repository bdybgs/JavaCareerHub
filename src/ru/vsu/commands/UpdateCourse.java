package ru.vsu.commands;

import ru.vsu.service.CoursesService;
import ru.vsu.service.CoursesServicesMemory;

import java.util.Scanner;

public class UpdateCourse implements TestatorCommand {

    private final CoursesService coursesService;
    private static UpdateCourse INSTANCE;

    public static UpdateCourse getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new UpdateCourse();
        }
        return INSTANCE;
    }

    public UpdateCourse(){
        this.coursesService= CoursesServicesMemory.getINSTANCE();
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Введите id курса который хотите поменять:");
        int id = Integer.parseInt(scanner.next());
        coursesService.getByID(id);
        System.out.println("Введите новое название:");
        String name = scanner.next();
        coursesService.updateName(id,name);
        System.out.println("Введите новое количество часов");
        int hours = Integer.parseInt(scanner.next());
        coursesService.updateHours(id, hours);
    }

    @Override
    public String printName() {
        return "Изменить курс";
    }
}
