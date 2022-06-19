package bowling.domain.frame;

import bowling.domain.Score;
import bowling.domain.state.State;
import bowling.domain.state.StateEnum;

public class NormalFrame extends AbstractFrame {

    public NormalFrame() {
        super();
    }

    @Override
    public void bowl(int countOfFallenPins) {
        if (fullFrameState.firstBowl(countOfFallenPins)) {
            return;
        }
        fullFrameState.secondBowl(countOfFallenPins);
    }

    @Override
    public boolean capableOfAdditionalBowling() {
        return fullFrameState.capableOfAdditionalBowling();
    }

    @Override
    public int getScore() {
        // 처음 값이 running, 두번째가 ready 이면 값을 0으로 출력,
        // 처음 값이 finish이면 score 값 가져오기.
        // 그리고 계산

        // 첫번째 상태가 finish이면 first 에서 score를 가져오고
        // 그렇지 않다면 두번째 상태를 가지고 score를 가져온다.

        // 만약 score가 기본값인 경우 -> return 0;
        // score 값을 가지고 계산


        Score score;
        if (StateEnum.isStrike(getFirstHalfFrameState())) {
            score = getFirstHalfFrameState().getScore();
        } else {
            score = getSecondHalfFrameState().getScore();
        }




//        if ((StateEnum.isFirstBowl(getFirstHalfFrameState()) || StateEnum.isGutter(getFirstHalfFrameState())) && StateEnum.isReady(getSecondHalfFrameState())) {
//            return NOT_COMPLETED_CALCULATION;
//        }
//
//        Score score = fullFrameState.createScore();
        if (score.canCalculateScore()) {
            return score.getScore();
        }

        return calculateAdditionalScore(score);
    }


    private int calculateAdditionalScore(Score beforeScore) {
        Score beforeBowl = null;
        if (incalculable(next.getFirstHalfFrameState())) {
            return NOT_COMPLETED_CALCULATION;
        }

        if (beforeScore.getLeft() == CALCULATE_ONCE) {
            beforeBowl = beforeScore.bowl(next.getFirstHalfFrameCountOfPins());
        }

        if (beforeScore.getLeft() == CALCULATE_TWICE) {
            beforeBowl = calculateTwice(beforeScore);
        }

        if (beforeBowl == null) {
            return next.getScore();
        }

        return beforeBowl.getScore();
    }

    private Score calculateTwice(Score beforeScore) {
        Score beforeBowl = beforeScore.bowl(next.getFirstHalfFrameCountOfPins());
        return addTwice(beforeBowl);
    }

    private Score addTwice(Score beforeBowl) {
        if (StateEnum.isReady(next.getSecondHalfFrameState())) {
            return secondAddition(beforeBowl);
        }
        return bowl(beforeBowl, next.getSecondHalfFrameState(), next.getSecondHalfFrameCountOfPins());
    }

    private Score secondAddition(Score beforeBowl) {
        if (next.next != null) {
            return bowl(beforeBowl, next.next.getFirstHalfFrameState(), next.next.getFirstHalfFrameCountOfPins());
        }
        return bowl(beforeBowl, next.getSecondHalfFrameState(), next.getSecondHalfFrameCountOfPins());
    }

    private boolean incalculable(State state) {
        return StateEnum.isReady(state);
    }

    private Score bowl(Score beforeBowl, State state, int countOfPins) {
        if (incalculable(state)) {
            return new Score();
        }
        return beforeBowl.bowl(countOfPins);
    }
}
