package bowling.domain.state;

import bowling.domain.Score;

public class FullFrameState {
    private static final int CALCULATE_TWICE = 2;
    private static final int CALCULATE_ONCE = 1;
    private static final int NO_MORE_CALCULATION = 0;

    private AbstractState firstHalfFrameState;
    private AbstractState secondHalfFrameState;

    public FullFrameState() {
        this.firstHalfFrameState = new Ready();
        this.secondHalfFrameState = new Ready();
    }

    public boolean firstBowl(int countOfFallenPins) {
        if (StateEnum.isReady(firstHalfFrameState)) {
            firstHalfFrameState = firstHalfFrameState.bowl(countOfFallenPins);
            return true;
        }
        return false;
    }

    public boolean secondBowl(int countOfFallenPins) {
        if (StateEnum.isReady(secondHalfFrameState)) {
            secondHalfFrameState = firstHalfFrameState.bowl(countOfFallenPins);
            return true;
        }
        return false;
    }

    public boolean finalDelivery(int countOfFallenPins) {
        if (firstBowl(countOfFallenPins)) {
            return true;
        }

        if (StateEnum.isStrike(firstHalfFrameState) && StateEnum.isReady(secondHalfFrameState)) {
            secondHalfFrameState = secondHalfFrameState.bowl(countOfFallenPins);
            return true;
        }

        return secondBowl(countOfFallenPins);
    }

    public boolean capableOfAdditionalBowling() {
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
        return firstHalfFrameState.getFallenPins() + secondHalfFrameState.fallenPins;
    }

    public AbstractState getFirstHalfFrameState() {
        return firstHalfFrameState;
    }

    public int getFirstHalfFrameCountOfFallenPins() {
        return firstHalfFrameState.getFallenPins();
    }

    public AbstractState getSecondHalfFrameState() {
        return secondHalfFrameState;
    }

    public int getSecondHalfFrameCountOfFallenPins() {
        return secondHalfFrameState.getFallenPins();
    }
}
