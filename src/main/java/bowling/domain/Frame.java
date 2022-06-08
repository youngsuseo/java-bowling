package bowling.domain;

public abstract class Frame {
    State firstState; // FIXME 우선 변수 3개로 하고 나중에 다시 1개가 되도록
    State secondState;
    Frame next;

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
