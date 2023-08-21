package org.example.application.frames;

import org.example.Helper;
import org.example.application.Input;
import org.example.Top;

import java.util.Scanner;

public class FrameEnter extends FrameImitation{

    @Override
    public FrameImitation start(Input input) {
        Scanner scanner = new Scanner(System.in);

        boolean b = true;
        while (b) {

            Helper.printLine("введите логин");
            String login = scanner.next();
            Helper.printLine("введите пароль");
            String password = scanner.next();

            if(Top.signIn(login,password)){
                return new FrameInformation("Вы вошли в систему, теперь вам доступно больше опций");
            }

            Helper.printLine(
                    "Неверно введён логин или пароль",
                    "желаете повторить попытку -> введите 1",
                    "не желаете повторить попытку -> введите любой из этих символов m,b,x "
            );
            int i = input.start().getNextInt();
            if (i != 1) { b = false; }

        }

        return null;
    }
}
