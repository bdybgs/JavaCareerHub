package ru.vsu.commands;

import ru.vsu.entities.LecturerWithCourse;
import ru.vsu.service.*;

import java.util.Scanner;

public class AddLecturersCourse implements TestatorCommand {
    private final LecturersWithCoursesService lecturersWithCourseService;
    private static AddLecturersCourse INSTANCE;

    public static AddLecturersCourse getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new AddLecturersCourse();
        }
        return INSTANCE;
    }

    public AddLecturersCourse(){
        this.lecturersWithCourseService = LecturersWithCoursesServicesMemory.getINSTANCE();
    }


    @Override
    public void execute(Scanner scanner) {
        scanner.nextLine();
        System.out.println("ID преподавателя: ");
        int idL = scanner.nextInt();
        lecturersWithCourseService.getLecturerByID(idL);
        System.out.println("ID курса: ");
        int idC = scanner.nextInt();
        lecturersWithCourseService.getCourseByID(idC);
        LecturerWithCourse newLecturer = new LecturerWithCourse(idL,idC);
        lecturersWithCourseService.add(newLecturer);
    }

    @Override
    public String printName() {
        return "Добавить курс преподавателю";
    }
}
