package org.example.application.frames;

import org.example.Helper;
import org.example.application.Input;

public class FrameInformation extends FrameImitation{
    private String text;
    public FrameInformation(String text) {
        this.text = text;
    }
    @Override
    public FrameImitation start(Input input) {
        Helper.printLine(text);
        input.start();
        return null;
    }
}
