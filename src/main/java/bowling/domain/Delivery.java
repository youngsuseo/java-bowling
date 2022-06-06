package bowling.domain;

import bowling.exception.InvalidScoreException;

public class Delivery {
    private static final int MAXIMUM_SCORE = 10;

    private final int countOfPins;
    private State state;

    public Delivery(int countOfPins) {
        this(countOfPins, new Ready());
    }

    public Delivery(int countOfPins, State state) {
        if (countOfPins > MAXIMUM_SCORE) {
            throw new InvalidScoreException("입력한 숫자는 " + MAXIMUM_SCORE + "을 넘을 수 없습니다.");
        }

        this.countOfPins = countOfPins;
        this.state = state;
    }

    public int getCountOfPins() {
        return countOfPins;
    }

    public State getState() {
        return state;
    }
}