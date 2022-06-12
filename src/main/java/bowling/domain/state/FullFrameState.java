package bowling.domain.state;

import bowling.domain.Score;

public class FullFrameState {
    private static final int CALCULATE_TWICE = 2;
    private static final int CALCULATE_ONCE = 1;
    private static final int NO_MORE_CALCULATION = 0;

    private State firstHalfFrameState;
    private State secondHalfFrameState;

    public FullFrameState() {
        this.firstHalfFrameState = new Ready();
        this.secondHalfFrameState = new Ready();
    }

    public boolean finalDelivery(int countOfPins) {
        if (firstBowl(countOfPins)) {
            return true;
        }

        if (StateEnum.isStrike(firstHalfFrameState) && StateEnum.isReady(secondHalfFrameState)) {
            secondHalfFrameState = secondHalfFrameState.bowl(countOfPins);
            return true;
        }

        return secondBowl(countOfPins);
    }

    public boolean firstBowl(int countOfPins) {
        if (StateEnum.isReady(firstHalfFrameState)) {
            firstHalfFrameState = firstHalfFrameState.bowl(countOfPins);
            return true;
        }
        return false;
    }

    public boolean secondBowl(int countOfPins) {
        if (StateEnum.isReady(secondHalfFrameState)) {
            secondHalfFrameState = firstHalfFrameState.bowl(countOfPins);
            return true;
        }
        return false;
    }

    public boolean additionallyDeliverable() {
        return (StateEnum.isReady(firstHalfFrameState) || StateEnum.isFirstBowl(firstHalfFrameState) || StateEnum.isGutter(firstHalfFrameState))
                && StateEnum.isReady(secondHalfFrameState);
    }

    public boolean additionallyFinalDeliverable() {
        return StateEnum.isStrike(firstHalfFrameState) || StateEnum.isSpare(secondHalfFrameState) || StateEnum.isReady(secondHalfFrameState);
    }

    public Score createScore() {
        int score = getThisFrameScore();
        if (StateEnum.isStrike(firstHalfFrameState)) {
            return new Score(score, CALCULATE_TWICE);
        }

        if (StateEnum.isSpare(secondHalfFrameState)) {
            return new Score(score, CALCULATE_ONCE);
        }

        return new Score(score, NO_MORE_CALCULATION);
    }

    private int getThisFrameScore() {
        return firstHalfFrameState.countOfPins + secondHalfFrameState.countOfPins;
    }

    public State getFirstHalfFrameState() {
        return firstHalfFrameState;
    }

    public State getSecondHalfFrameState() {
        return secondHalfFrameState;
    }
}
