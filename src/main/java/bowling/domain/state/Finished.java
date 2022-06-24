package bowling.domain.state;

abstract class Finished extends AbstractState {

    Finished(int fallenPins, String symbol) {
        super(fallenPins, symbol);
    }
}
