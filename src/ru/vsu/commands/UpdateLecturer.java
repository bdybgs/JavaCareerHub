package ru.vsu.commands;

import ru.vsu.service.LecturersService;
import ru.vsu.service.LecturersServicesMemory;

import java.util.Scanner;

public class UpdateLecturer implements TestatorCommand {

    private final LecturersService lecturersService;
    private static UpdateLecturer INSTANCE;

    public static UpdateLecturer getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new UpdateLecturer();
        }
        return INSTANCE;
    }

    public UpdateLecturer(){
        this.lecturersService= LecturersServicesMemory.getINSTANCE();
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Введите ID обновляемого преподавателя:");
        int id = Integer.parseInt(scanner.next());
        lecturersService.getByID(id);
        System.out.println("Введите новое имя:");
        String name = scanner.next();
        lecturersService.updateName(id,name);
        System.out.println("Введите новую фамилию:");
        String surname = scanner.next();
        lecturersService.updateSurname(id,surname);
    }

    @Override
    public String printName() {
        return "Обновить преподавателя";
    }
}
