package bowling.domain.frame;

import bowling.domain.state.AbstractState;
import bowling.domain.state.FullFrameState;

public abstract class AbstractFrame implements Frame {
    static final int NOT_COMPLETED_CALCULATION = 0;
    static final int CALCULATE_TWICE = 2;
    static final int CALCULATE_ONCE = 1;

    FullFrameState fullFrameState;
    AbstractFrame next;

    AbstractFrame() {
        this.fullFrameState = new FullFrameState();
        this.next = null;
    }

    public abstract void bowl(int fallenPinsCount);

    public abstract boolean capableOfAdditionalBowling();

    public abstract int getScore();

    public AbstractState getFirstHalfFrameState() {
        return fullFrameState.getFirstHalfFrameState();
    }

    int getFirstHalfFrameCountOfPins() {
        return fullFrameState.getFirstHalfFrameCountOfFallenPins();
    }

    public AbstractState getSecondHalfFrameState() {
        return fullFrameState.getSecondHalfFrameState();
    }

    int getSecondHalfFrameCountOfPins() {
        return fullFrameState.getSecondHalfFrameCountOfFallenPins();
    }
}
