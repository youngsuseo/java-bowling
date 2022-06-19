package bowling.domain.state;

public abstract class Finished extends AbstractState {

    public Finished(int fallenPins, String symbol) {
        super(fallenPins, symbol);
    }
}
