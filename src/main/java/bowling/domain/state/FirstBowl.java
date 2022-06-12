package bowling.domain.state;

public class FirstBowl extends State {
    public FirstBowl(int firstBowl) {
        validCount(firstBowl);
        this.countOfPins = firstBowl;
        this.symbol = String.valueOf(firstBowl);
    }

    @Override
    public State bowl(int secondBowl) {
        return bowlSecond(secondBowl);
    }
}
