package ru.vsu.commands;

import ru.vsu.service.LecturersService;
import ru.vsu.service.LecturersServicesMemory;

import java.util.Scanner;

public class DeleteLecturer implements TestatorCommand {
    private final LecturersService lecturersService;
    private static DeleteLecturer INSTANCE;

    public static DeleteLecturer getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new DeleteLecturer();
        }
        return INSTANCE;
    }

    public DeleteLecturer(){
        this.lecturersService= LecturersServicesMemory.getINSTANCE();
    }


    @Override
    public void execute(Scanner scanner) {
        scanner.nextLine();
        System.out.println("ID преподавателя: ");
        int id = scanner.nextInt();
        lecturersService.delete(id);
    }

    @Override
    public String printName() {
        return "Удалить преподавателя";
    }
}
