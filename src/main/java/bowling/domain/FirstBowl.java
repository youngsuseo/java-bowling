package bowling.domain;

import bowling.exception.InvalidScoreException;

public class FirstBowl extends State {
    public FirstBowl(int firstBowl) {
        validCount(firstBowl);
        this.countOfPins = firstBowl;
        this.symbol = String.valueOf(firstBowl);
    }

    @Override
    public State bowl(int secondBowl) {
        this.validCount(secondBowl);
        if (this.countOfPins + secondBowl == MAX_COUNT_OF_PINS) {
            return new Spare(this.countOfPins, secondBowl);
        }

        return new Miss(this.countOfPins, secondBowl);
    }

    @Override
    void validCount(int countOfPins) {
        if (countOfPins > MAX_COUNT_OF_PINS || this.countOfPins + countOfPins > MAX_COUNT_OF_PINS) {
            throw new InvalidScoreException("핀을 쓰러뜨린 수는 10을 초과할 수 없습니다.");
        }
    }
}
