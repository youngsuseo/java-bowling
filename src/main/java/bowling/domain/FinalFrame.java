package bowling.domain;

public class FinalFrame extends NormalFrame {
    private State bonusState;

    FinalFrame() {
        super();
        this.bonusState = new Ready();
    }

    @Override
    public void delivery(int countOfPins) {
        if (states.finalDelivery(countOfPins)) {
            return;
        }

        if (states.getSecondState() instanceof Strike || states.getSecondState() instanceof Spare) {
            bonusState = bonusState.bowl(countOfPins);
            return;
        }

        if (states.getFirstState() instanceof Strike) {
            bonusState = states.getSecondState().bowl(countOfPins);
        }
    }



    @Override
    public boolean additionallyDeliverable() {
        return bonusState instanceof Ready && states.finalAdditionallyDeliverable();
    }

    @Override
    public int getScore() {
        if ((states.getSecondState() instanceof Ready || states.getSecondState() instanceof Spare) && (bonusState instanceof Ready)) {
            return 0;
        }

        return states.getFirstState().countOfPins + states.getSecondState().countOfPins + bonusState.countOfPins;
    }

    public State getBonusState() {
        return bonusState;
    }
}
