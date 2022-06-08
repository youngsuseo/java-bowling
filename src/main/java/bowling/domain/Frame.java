package bowling.domain;

public abstract class Frame {
    States states;
    Frame next;

    public abstract void delivery(int countOfPins);

    public abstract boolean additionallyDeliverable();

    public abstract int getScore();

    public States getStates() {
        return states;
    }

    public Frame getNext() {
        return next;
    }

    public State getFirstState() {
        return states.getFirstState();
    }

    public State getSecondState() {
        return states.getSecondState();
    }
}
