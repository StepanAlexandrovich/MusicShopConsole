package org.example.application.frames;

import org.example.Helper;
import org.example.Top;
import org.example.application.frames.helpers.FrameImitation;
import org.example.application.frames.helpers.FramePassage;

import java.util.Scanner;

public class FrameAddNewPerformer extends FramePassage {
    private String firstName;
    private String middleName;
    private String lastName;
    private String description;
    private String country;

    @Override
    public void startInput(Scanner scanner) {
        Helper.printLine("Введите имя исполнителя");
        firstName = scanner.next();
        Helper.printLine("Введите middleName исполнителя");
        middleName = scanner.next();
        Helper.printLine("Введите lastName исполнителя");
        lastName = scanner.next();
        Helper.printLine("опишите исполнителя");
        description = scanner.next();
        Helper.printLine("Введите страну исполнителя");
        country = scanner.next();
    }

    @Override
    public boolean result() {
        return Top.performerService.add(firstName,middleName,lastName,description,country)!=null;
    }

    @Override
    public void messageSuccess() {
        Helper.printLine("Исполнитель успешно добавлен");
        standardMessageSuccess();
    }
    @Override
    public FrameImitation getNextFrame() {
        return null;
    }
    @Override
    public void messageFailure() {
        Helper.printLine("Исполнитель не добавлен");
        standardMessageFailure();
    }
}
