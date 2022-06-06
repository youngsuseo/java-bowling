package bowling.domain;

public abstract class Frame {
    State firstState;
    State secondState;

    public abstract void delivery(int countOfPins);

    public abstract boolean additionallyDeliverable();

    public abstract int getScore();

    public State getFirstState() {
        return firstState;
    }

    public State getSecondState() {
        return secondState;
    }
}
