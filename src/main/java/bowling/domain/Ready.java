package bowling.domain;

public class Ready extends State {
    @Override
    public State bowl(int countOfPins) {
        validCount(countOfPins);
        if (MAX_COUNT_OF_PINS == countOfPins) {
            return new Strike();
        }

        return new FirstBowl(countOfPins);
    }
}
