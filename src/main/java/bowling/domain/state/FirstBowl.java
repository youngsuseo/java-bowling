package bowling.domain.state;

import bowling.domain.Score;

public class FirstBowl extends Running {

    public FirstBowl(int firstBowl) {
        super(firstBowl, String.valueOf(firstBowl));
    }

    @Override
    public AbstractState bowl(int fallenPins) {
        return bowlSecond(fallenPins);
    }

    @Override
    public Score calculateAdditionalScore(Score score) {
        return null;
    }
}
