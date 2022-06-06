package bowling.domain;

public class Gutter extends State {
    private static final String GUTTER_SYMBOL = "-";

    public Gutter() {
        super(MIN_COUNT_OF_PINS, GUTTER_SYMBOL);
    }

    @Override
    public State bowl(int firstBowl) {
        return null;
    }
}
