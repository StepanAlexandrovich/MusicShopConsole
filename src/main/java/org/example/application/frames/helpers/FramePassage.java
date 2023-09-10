package org.example.application.frames.helpers;

import org.example.Helper;
import org.example.application.Input;

import java.util.Scanner;

public abstract class FramePassage extends FrameImitation {
    @Override
    public FrameImitation start(Input input) {
        Scanner scanner = new Scanner(System.in);

        boolean b = true;
        boolean result = false;

        while (b) {
            startInput(scanner);

            if(result = result()){
                messageSuccess();
            }else{
                messageFailure();
            }

            int i = input.start().getNextInt();
            if (result || i != 1) { b = false; }
        }

        return getNextFrame();
    }
    public abstract void startInput(Scanner scanner);
    public abstract boolean result();
    public abstract void messageSuccess();
    public abstract FrameImitation getNextFrame();
    public abstract void messageFailure();

    //-----------------------------------------
    public void standardMessageSuccess(){
        Helper.printLine(
                "введите любой из этих символов m,b,x что бы выйти из этого окна "
        );
    }

    public void standardMessageFailure(){
        Helper.printLine(
                "желаете повторить попытку -> введите 1",
                "не желаете повторить попытку -> введите любой из этих символов m,b,x "
        );
    }

}
