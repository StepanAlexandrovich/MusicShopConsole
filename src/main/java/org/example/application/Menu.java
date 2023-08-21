package org.example.application;

import org.example.Helper;
import org.example.application.frames.FrameImitation;
import org.example.application.frames.FrameMenu;

import java.util.Scanner;

public class Menu {
    Input input = new Input() {
        private int nextInt;
        private String nextString;
        private Scanner scanner = new Scanner(System.in);
        public int getNextInt() {
            return nextInt;
        }
        public String getNextString() { return nextString; }

        @Override
        public Input start() {
            nextString = "";
            nextInt = -100000000;

            if(scanner.hasNextInt()){
                nextInt = scanner.nextInt();
            }else{
                nextString = scanner.next();
            }

            return this;
        }

    };

    public void start() {
        Helper.printLine(
                "ДАННЫЕ СИМВОЛЫ ДЕЙСТВУЮТ НА ВСЕХ ЭТАПАХ ПРИЛОЖЕНИЯ",
                " m -> вернуться в главное меню",
                " b -> вернуться на один шаг назад",
                " x -> закрыть приложение"
        );

        FrameImitation frame = new FrameMenu();
        FrameImitation frameRoot = frame;

        // cycle //
        while (frame != null) {
            frame.next = frame.start(input);

            if(frame.next == null){
                switch (input.getNextString()){
                    case "x": frame = null;        break;
                    case "b": frame = frame.back;  break;
                    case "m": frame = frameRoot;   break;
                    default: Helper.inputIncorrect(); break;
                }
            }else{
                frame.next.back = frame;
                frame = frame.next;
                frame.back.next = null;
            }
        }

    }

}
