package ru.vsu.commands;

import ru.vsu.entities.LecturerWithCourse;
import ru.vsu.service.*;

import java.util.Scanner;

public class DeleteLecturersCourse implements TestatorCommand {
    private final LecturersWithCoursesService lecturersWithCourseService;
    private static DeleteLecturersCourse INSTANCE;

    public static DeleteLecturersCourse getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new DeleteLecturersCourse();
        }
        return INSTANCE;
    }

    public DeleteLecturersCourse(){
        this.lecturersWithCourseService= LecturersWithCoursesServicesMemory.getINSTANCE();
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
        lecturersWithCourseService.delete(idL,idC);
    }

    @Override
    public String printName() {
        return "Удалить курс у преподавателя";
    }
}
