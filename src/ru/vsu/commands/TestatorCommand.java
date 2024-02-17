package ru.vsu.commands;

import java.util.Scanner;

public interface TestatorCommand {
    public abstract void execute(Scanner scanner);
    public abstract String printName();
}
