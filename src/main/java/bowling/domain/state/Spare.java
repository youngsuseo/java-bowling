package bowling.domain.state;

import bowling.exception.IllegalBowlException;

public class Spare extends State {
    private static final String SPARE_SYMBOL = "/";

    private int preBowl;

    public Spare(int firstBowl, int secondBowl) {
        super(secondBowl, SPARE_SYMBOL);
        this.preBowl = firstBowl;
    }

    @Override
    public State bowl(int firstBowl) {
        throw new IllegalBowlException("실행할 수 없는 메서드 입니다.");
    }
}
