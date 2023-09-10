package org.example.application.frames;

import org.example.Helper;
import org.example.Top;
import org.example.application.frames.helpers.FrameImitation;
import org.example.application.frames.helpers.FramePassage;

import java.util.Scanner;

public class FrameEnter extends FramePassage {
    private String login;
    private String password;
    @Override
    public void startInput(Scanner scanner) {
        Helper.printLine("введите логин");
        login = scanner.next();
        Helper.printLine("введите пароль");
        password = scanner.next();
    }

    @Override
    public boolean result() {
        return Top.signIn(login,password);
    }

    @Override
    public void messageSuccess() {
        Helper.printLine("Вы вошли в систему как "+Top.user.getType() + ", теперь вам доступно больше опций");
        standardMessageSuccess();
    }
    @Override
    public FrameImitation getNextFrame() { return null; }
    @Override
    public void messageFailure() {
        Helper.printLine("Неверно введён логин или пароль");
        standardMessageFailure();
    }
}
