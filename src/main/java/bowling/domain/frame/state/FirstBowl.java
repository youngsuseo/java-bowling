package bowling.domain.frame.state;

import bowling.domain.Pins;

public class FirstBowl implements State {

    private static final String PINS_STATE = "%3d   ";

    private final Pins firstPins;

    public FirstBowl(final Pins firstPins) {
        this.firstPins = firstPins;
    }

    @Override
    public State bowl(int pinsCount) {
        Pins second = firstPins.bowl(pinsCount);
        if (second.isFinish()) {
            return new Spare(firstPins, second);
        }

        if (second.isGutter()) {
            return new Gutter();
        }

        return new Miss(firstPins, second);
    }

    @Override
    public boolean isFinish() {
        return false;
    }

    @Override
    public String getCurrentPinsState() {
        if (firstPins.getDownPin() == 0) {
            return "  -  ";
        }
        return String.format(PINS_STATE, firstPins.getDownPin());
    }
}