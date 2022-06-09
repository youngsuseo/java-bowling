package bowling.domain;

public class States {
    private State firstState;
    private State secondState;

    public States() {
        this.firstState = new Ready();
        this.secondState = new Ready();
    }

    public States(State firstState, State secondState) {
        this.firstState = firstState;
        this.secondState = secondState;
    }

    public boolean finalDelivery(int countOfPins) {
        if (firstBowl(countOfPins)) {
            return true;
        }

        if (firstState instanceof Strike && secondState instanceof Ready) { // FIXME 조건 변경 가능한지 확인
            secondState = secondState.bowl(countOfPins);
            return true;
        }

        return secondBowl(countOfPins);
    }

    boolean firstBowl(int countOfPins) {
        if (firstState instanceof Ready) {
            firstState = firstState.bowl(countOfPins);
            return true;
        }
        return false;
    }

    boolean secondBowl(int countOfPins) {
        if (secondState instanceof Ready) { // FIXME instanceOf 대신 사용할 수 있는 것?
            secondState = firstState.bowl(countOfPins);
            return true;
        }
        return false;
    }

    public boolean additionallyDeliverable() {// FIXME 조건 변경 가능한지 확인
        return (firstState instanceof Ready || firstState instanceof FirstBowl || firstState instanceof Gutter) && secondState instanceof Ready;
    }

    public boolean finalAdditionallyDeliverable() {
        return firstState instanceof Strike || secondState instanceof Spare || secondState instanceof Ready;
    }

    Score createScore() {
        int score = getThisFrameScore();
        if (firstState instanceof Strike) {
            return new Score(score, 2);
        }

        if (secondState instanceof Spare) {
            return new Score(score, 1);
        }

        return new Score(score, 0);
    }

    private int getThisFrameScore() {
        return firstState.countOfPins + secondState.countOfPins;
    }

    public State getFirstState() {
        return firstState;
    }

    public State getSecondState() {
        return secondState;
    }
}
