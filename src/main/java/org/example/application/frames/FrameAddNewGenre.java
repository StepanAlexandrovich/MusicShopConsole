package org.example.application.frames;

import org.example.Helper;
import org.example.Top;
import org.example.application.frames.helpers.FrameImitation;
import org.example.application.frames.helpers.FramePassage;

import java.util.Scanner;

public class FrameAddNewGenre extends FramePassage {
    private String name;
    private String description;
    @Override
    public void startInput(Scanner scanner) {
        Helper.printLine("Введите имя жанра");
        name = scanner.next();
        Helper.printLine("Введите описание жанра");
        description = scanner.next();
    }
    @Override
    public boolean result() { return Top.genreService.add(name,description)!=null; }
    @Override
    public void messageSuccess() {
        Helper.printLine("Жанр успешно добавлен");
        standardMessageSuccess();
        //Helper.printLine("нажмите любую клавишу что бы пройти далее");
    }
    @Override
    public FrameImitation getNextFrame() {
        //return new FrameInformation("вы прошли далее");
        return null;
    }
    @Override
    public void messageFailure() {
        Helper.printLine("Жанр не добавлен");
        standardMessageFailure();
    }
}
