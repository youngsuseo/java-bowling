package bowling.domain;

public class FinalFrame extends NormalFrame {
    private State bonusState;

    public FinalFrame() {
        super();
        this.bonusState = new Ready();
    }

    @Override
    public void delivery(int countOfPins) {
        if (firstState instanceof Ready) {
            firstState = firstState.bowl(countOfPins);
            return;
        }

        if (firstState instanceof Strike && secondState instanceof Ready) {
            secondState = secondState.bowl(countOfPins);
            return;
        }

        if (secondState instanceof Ready) {
            secondState = firstState.bowl(countOfPins);
            return;
        }

        if (secondState instanceof Strike || secondState instanceof Spare) {
            bonusState = bonusState.bowl(countOfPins);
            return;
        }

        if (firstState instanceof Strike) {
            bonusState = secondState.bowl(countOfPins);
        }
    }

    @Override
    public boolean additionallyDeliverable() {
        return bonusState instanceof Ready
                && (firstState instanceof Strike || secondState instanceof Spare || secondState instanceof Ready);
    }

    @Override
    public int getScore() {
        if ((secondState instanceof Ready || secondState instanceof Spare) && (bonusState instanceof Ready)) {
            return 0;
        }

        return firstState.countOfPins + secondState.countOfPins + bonusState.countOfPins;
    }

    public State getSecondState() {
        return secondState;
    }

    public State getBonusState() {
        return bonusState;
    }
}
