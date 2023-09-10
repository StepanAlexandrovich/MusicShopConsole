package org.example.application.frames;

import org.example.Helper;
import org.example.application.Input;
import org.example.application.frames.helpers.FrameImitation;

public class FrameInformation extends FrameImitation {
    private String text;
    public FrameInformation(String text) {
        this.text = text;
    }
    @Override
    public FrameImitation start(Input input) {
        Helper.printLine(text);
        Helper.printLine(" m -> вернуться в главное меню",
                " b -> вернуться на один шаг назад",
                " x -> закрыть приложение"
        );
        input.start();
        return null;
    }
}
