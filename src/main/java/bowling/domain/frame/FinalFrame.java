package bowling.domain.frame;

import bowling.domain.state.Ready;
import bowling.domain.state.State;
import bowling.domain.state.StateEnum;

public class FinalFrame extends NormalFrame {
    private static final int NOT_COMPLETED_CALCULATION = 0;

    private State bonusState;

    FinalFrame() {
        super();
        this.bonusState = new Ready();
    }

    @Override
    public void delivery(int countOfPins) {
        if (fullFrameState.finalDelivery(countOfPins)) {
            return;
        }

        if (StateEnum.isStrike(secondState()) || StateEnum.isSpare(secondState())) {
            bonusState = bonusState.bowl(countOfPins);
            return;
        }

        if (StateEnum.isStrike(firstState())) {
            bonusState = fullFrameState.getSecondHalfFrameState().bowl(countOfPins);
        }
    }

    @Override
    public boolean additionallyDeliverable() {
        return StateEnum.isReady(bonusState) && fullFrameState.additionallyFinalDeliverable();
    }

    @Override
    public int getScore() {
        if ((StateEnum.isReady(secondState()) || StateEnum.isSpare(secondState()) || StateEnum.isStrike(secondState()))
                && StateEnum.isReady(bonusState)) {
            return NOT_COMPLETED_CALCULATION;
        }

        return firstState().getCountOfPins() + secondState().getCountOfPins() + bonusState.getCountOfPins();
    }

    public State getBonusState() {
        return bonusState;
    }
}
