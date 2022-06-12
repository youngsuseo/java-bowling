package bowling.domain.state;

import bowling.domain.state.State;
import bowling.exception.IllegalBowlException;

public class Strike extends State {
    private static final String STRIKE_SYMBOL = "X";

    public Strike() {
        super(MAX_COUNT_OF_PINS, STRIKE_SYMBOL);
    }

    @Override
    public State bowl(int firstBowl) { // FIXME 테스트 필요
        throw new IllegalBowlException("실행할 수 없는 메서드 입니다.");
    }
}
