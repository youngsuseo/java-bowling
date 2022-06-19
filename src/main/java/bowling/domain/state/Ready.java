package bowling.domain.state;

public class Ready extends Running {

    public Ready() {
    }

    public Ready(int fallenPins, String symbol) {
        super(fallenPins, symbol);
    }

    @Override
    public AbstractState bowl(int fallenPins) {
        if (MAX_COUNT_OF_PINS == fallenPins) {
            return new Strike();
        }

        if (MIN_COUNT_OF_PINS == fallenPins) {
            return new Gutter();
        }

        return new FirstBowl(fallenPins);
    }
}
