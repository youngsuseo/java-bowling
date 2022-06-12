package bowling.domain.frame;

import bowling.domain.Score;
import bowling.domain.state.State;
import bowling.domain.state.StateEnum;
import bowling.domain.state.FullFrameState;

public class NormalFrame extends Frame {
    private static final int NOT_COMPLETED_CALCULATION = 0;
    private static final int CALCULATE_TWICE = 2;
    private static final int CALCULATE_ONCE = 1;

    public NormalFrame() {
        this.fullFrameState = new FullFrameState();
        this.next = null;
    }

    @Override
    public void delivery(int countOfPins) {
        if (fullFrameState.firstBowl(countOfPins)) {
            return;
        }
        fullFrameState.secondBowl(countOfPins);
    }

    @Override
    public boolean additionallyDeliverable() {
        return fullFrameState.additionallyDeliverable();
    }

    @Override
    public int getScore() {
        if ((StateEnum.isFirstBowl(firstState()) || StateEnum.isFirstBowl(firstState())) && StateEnum.isReady(secondState())) {
            return NOT_COMPLETED_CALCULATION;
        }

        Score score = fullFrameState.createScore();
        if (score.canCalculateScore()) {
            return score.getScore();
        }

        return calculateAdditionalScore(score);
    }


    private int calculateAdditionalScore(Score beforeScore) {
        Score beforeBowl = null;
        if (incalculable(next.getFirstState())) {
            return NOT_COMPLETED_CALCULATION;
        }

        if (beforeScore.getLeft() == CALCULATE_ONCE) {
            beforeBowl = beforeScore.bowl(next.getFirstState().getCountOfPins());
        }

        if (beforeScore.getLeft() == CALCULATE_TWICE) {
            beforeBowl = calculateTwice(beforeScore);
        }

        if (beforeBowl == null) {
            return next.getScore();
        }

        return beforeBowl.getScore();
    }

    private Score calculateTwice(Score beforeScore) {
        Score beforeBowl = beforeScore.bowl(next.getFirstState().getCountOfPins());
        return addTwice(beforeBowl);
    }

    private Score addTwice(Score beforeBowl) {
        if (StateEnum.isReady(next.getSecondState())) {
            return secondAddition(beforeBowl);
        }
        return bowl(beforeBowl, next.getSecondState(), next.getSecondState().getCountOfPins());
    }

    private Score secondAddition(Score beforeBowl) { // FIXME 디미터 법칙
        if (next.next == null) {
            return bowl(beforeBowl, next.getSecondState(), next.getSecondState().getCountOfPins());
        }
        return bowl(beforeBowl, next.next.getFirstState(), next.next.getFirstState().getCountOfPins());
    }

    private boolean incalculable(State state) {
        return StateEnum.isReady(state);
    }

    private Score bowl(Score beforeBowl, State state, int countOfPins) {
        if (incalculable(state)) {
            return new Score();
        }
        return beforeBowl.bowl(countOfPins);
    }

    public State firstState() {
        return fullFrameState.getFirstHalfFrameState();
    }

    public State secondState() {
        return fullFrameState.getSecondHalfFrameState();
    }
}
