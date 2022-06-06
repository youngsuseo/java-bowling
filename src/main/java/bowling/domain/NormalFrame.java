package bowling.domain;

class NormalFrame extends Frame {
    NormalFrame() {
        this.firstState = new Ready();
        this.secondState = new Ready();
    }

    @Override
    public void delivery(int countOfPins) {
        if (firstState instanceof Ready) {
            firstState = firstState.bowl(countOfPins);
            return;
        }
        secondState = firstState.bowl(countOfPins);
    }

    @Override
    public boolean additionallyDeliverable() {
        return (firstState instanceof Ready || firstState instanceof FirstBowl) && secondState instanceof Ready;
    }

    @Override
    public int getScore() {
        if (firstState instanceof FirstBowl && secondState instanceof Ready) {
            return 0;
        }

        return firstState.getCountOfPins() + secondState.getCountOfPins();
    }
}
