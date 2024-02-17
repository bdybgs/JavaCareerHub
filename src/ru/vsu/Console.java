package ru.vsu;

import ru.vsu.commands.*;

import java.util.Scanner;

public class Console {
    private final Scanner scanner = new Scanner(System.in);
    private final TestatorCommand[] commands;
    public Console(){
        this.commands = new TestatorCommand[]{
                PrintAllLecturersWithCourses.getINSTANCE(),
                PrintAllCourses.getINSTANCE(),
                PrintAllLecturers.getINSTANCE(),
                AddCourse.getINSTANCE(),
                AddLecturer.getINSTANCE(),
                AddLecturersCourse.getINSTANCE(),
                DeleteLecturer.getINSTANCE(),
                DeleteLecturersCourse.getINSTANCE(),
                UpdateLecturer.getINSTANCE(),
                UpdateCourse.getINSTANCE(),};
    }

    public void start(){
        while (true){
            System.out.println("Выберете команду");
            System.out.println("0. Выход");
            for (int i = 0; i < commands.length; i++) {
                System.out.println( i+1 + ". " + commands[i].printName());
            }
            int pickedCommand = Integer.parseInt(scanner.next());
            if (pickedCommand == 0) {
                break;
            }

            if (pickedCommand < commands.length+1 && pickedCommand > 0) {
                try {
                    commands[pickedCommand-1].execute(scanner);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
