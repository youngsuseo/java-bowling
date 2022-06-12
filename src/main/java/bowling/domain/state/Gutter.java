package bowling.domain.state;

public class Gutter extends State {
    private static final String GUTTER_SYMBOL = "-";

    public Gutter() {
        super(MIN_COUNT_OF_PINS, GUTTER_SYMBOL);
    }

    @Override
    public State bowl(int secondBowl) {
        return bowlSecond(secondBowl);
    }
}
