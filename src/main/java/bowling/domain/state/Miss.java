package bowling.domain.state;

import bowling.domain.Score;
import bowling.exception.IllegalBowlException;

public class Miss extends Finished {
    private int preBowl;

    public Miss(int firstBowl, int secondBowl) {
        super(secondBowl, String.valueOf(secondBowl));
        this.preBowl = firstBowl;
    }

    @Override
    public AbstractState bowl(int fallenPins) {
        throw new IllegalBowlException("실행할 수 없는 메서드 입니다.");
    }

    @Override
    public Score getScore() {
        return new Score(fallenPins + preBowl, NO_MORE_CALCULATION);
    }
}
