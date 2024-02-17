package ru.vsu.commands;

import ru.vsu.entities.Lecturer;
import ru.vsu.service.LecturersService;
import ru.vsu.service.LecturersServicesMemory;

import java.util.Scanner;

public class AddLecturer implements TestatorCommand {

    private final LecturersService lecturersService;
    private static AddLecturer INSTANCE;

    public static AddLecturer getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new AddLecturer();
        }
        return INSTANCE;
    }

    public AddLecturer(){
        this.lecturersService= LecturersServicesMemory.getINSTANCE();
    }

    @Override
    public void execute(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Имя преподавателя: ");
        String firstName = scanner.nextLine();
        System.out.println("Фамилия преподавателя: ");
        String lastName = scanner.nextLine();
        lecturersService.add(new Lecturer(firstName, lastName));

        //System.out.println(lecturer.getID() + " created");
    }

    @Override
    public String printName() {
        return "Добавить преподавателя";
    }
}
