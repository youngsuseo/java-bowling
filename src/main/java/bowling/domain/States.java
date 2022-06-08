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

    public void delivery(int countOfPins) {
        if (firstState instanceof Ready) {
            firstState = firstState.bowl(countOfPins);
            return;
        }
        secondState = firstState.bowl(countOfPins);
    }

    public boolean finalDelivery(int countOfPins) {
        if (firstState instanceof Ready) {
            firstState = firstState.bowl(countOfPins);
            return true;
        }

        if (firstState instanceof Strike && secondState instanceof Ready) {
            secondState = secondState.bowl(countOfPins);
            return true;
        }

        if (secondState instanceof Ready) {
            secondState = firstState.bowl(countOfPins);
            return true;
        }
        return false;
    }

    public boolean additionallyDeliverable() {
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
