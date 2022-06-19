package bowling.domain.state;

import bowling.domain.Score;
import bowling.exception.IllegalBowlException;

public class Spare extends Finished {
    private static final String SPARE_SYMBOL = "/";

    private int preBowl;

    public Spare(int firstBowl, int secondBowl) {
        super(secondBowl, SPARE_SYMBOL);
        this.preBowl = firstBowl;
    }

    @Override
    public AbstractState bowl(int fallenPins) {
        throw new IllegalBowlException("실행할 수 없는 메서드 입니다.");
    }

    @Override
    public Score getScore() {
        return new Score(fallenPins + preBowl, CALCULATE_ONCE);
    }
}
