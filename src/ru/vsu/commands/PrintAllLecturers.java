package ru.vsu.commands;

import ru.vsu.entities.Lecturer;
import ru.vsu.service.LecturersService;
import ru.vsu.service.LecturersServicesMemory;

import java.util.Scanner;

public class PrintAllLecturers implements TestatorCommand {
    private final LecturersService lecturersService;
    private static PrintAllLecturers INSTANCE;

    public static PrintAllLecturers getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new PrintAllLecturers();
        }
        return INSTANCE;
    }

    public PrintAllLecturers(){
        this.lecturersService= LecturersServicesMemory.getINSTANCE();
    }

    @Override
    public void execute(Scanner scanner) {
        for (Lecturer lecturer: lecturersService.getAll()){
            System.out.println("ID: " + lecturer.getID()+" Имя: "+lecturer.getName()+" Фамилия: "+lecturer.getSurname());
        }
    }

    @Override
    public String printName() {
        return "Вывести всех преподавателей";
    }
}
