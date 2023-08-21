package org.example.application.frames;

import org.example.application.Input;

public abstract class FrameImitation {
    public FrameImitation next,back;
    public abstract FrameImitation start(Input input);
}
