package bowling.domain.frame;

import bowling.domain.state.State;
import bowling.domain.state.FullFrameState;

public abstract class Frame {
    FullFrameState fullFrameState;
    Frame next;

    public abstract void delivery(int countOfPins);

    public abstract boolean additionallyDeliverable();

    public abstract int getScore();

    public FullFrameState getFullFrameState() {
        return fullFrameState;
    }

    public State getFirstState() {
        return fullFrameState.getFirstHalfFrameState();
    }

    public State getSecondState() {
        return fullFrameState.getSecondHalfFrameState();
    }
}
