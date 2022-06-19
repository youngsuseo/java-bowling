package bowling.domain.state;

import bowling.domain.Score;

public interface State {

    AbstractState bowl(int fallenPins);

//    boolean isFinished();

    Score getScore();

    Score calculateAdditionalScore(Score score);

//    String getDesc();
}
