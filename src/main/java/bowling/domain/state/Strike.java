package bowling.domain.state;

import bowling.domain.Score;
import bowling.exception.IllegalBowlException;

public class Strike extends Finished {
    private static final String STRIKE_SYMBOL = "X";

    public Strike() {
        super(MAX_COUNT_OF_PINS, STRIKE_SYMBOL);
    }

    @Override
    public AbstractState bowl(int fallenPins) { // FIXME 테스트 필요
        throw new IllegalBowlException("실행할 수 없는 메서드 입니다.");
    }

    @Override
    public Score getScore() {
        return new Score(fallenPins, CALCULATE_TWICE);
    }
}
