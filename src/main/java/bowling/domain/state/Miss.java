package bowling.domain.state;

import bowling.exception.IllegalBowlException;

public class Miss extends State {
    private int preBowl;

    public Miss(int firstBowl, int secondBowl) {
        super(secondBowl, String.valueOf(secondBowl));
        this.preBowl = firstBowl;
    }

    @Override
    public State bowl(int firstBowl) {
        throw new IllegalBowlException("실행할 수 없는 메서드 입니다.");
    }
}
