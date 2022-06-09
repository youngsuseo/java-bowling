package bowling.domain;

class NormalFrame extends Frame {
    private static final int NOT_COMPLETED_CALCULATION = 0;
    private static final int CALCULATE_TWICE = 2;
    private static final int CALCULATE_ONCE = 1;

    NormalFrame() {
        this.states = new States();
        this.next = null;
    }

    @Override
    public void delivery(int countOfPins) {
        if (states.firstBowl(countOfPins)) {
            return;
        }
        states.secondBowl(countOfPins);
    }

    @Override
    public boolean additionallyDeliverable() {
        return states.additionallyDeliverable();
    }

    @Override
    public int getScore() {
        if (StateEnum.isFirstBowl(firstState()) && StateEnum.isReady(secondState())) {
            return 0;
        }

        Score score = states.createScore();
        if (score.canCalculateScore()) {
            return score.getScore();
        }

        return calculateAdditionalScore(score);
    }


    private int calculateAdditionalScore(Score beforeScore) {
        // TODO beforeScore에 현재 Frame의 쓰러진 Pin을 추가해 점수를 구하는 로직 구현
        Score beforeBowl = null;
        if (next.states.getFirstState() instanceof Ready) {
            return NOT_COMPLETED_CALCULATION;
        }

        if (beforeScore.getLeft() == CALCULATE_ONCE) {
            beforeBowl = beforeScore.bowl(next.states.getFirstState().countOfPins);
        }

        if (beforeScore.getLeft() == CALCULATE_TWICE) {
            beforeBowl = beforeScore.bowl(next.states.getFirstState().countOfPins);
            if (next.states.getSecondState() instanceof Ready) {

                if (next.next == null) {
                    if (next.states.getSecondState() instanceof Ready) {
                        return NOT_COMPLETED_CALCULATION;
                    }
                    beforeBowl = beforeBowl.bowl(next.states.getSecondState().countOfPins);
                } else {
                    if (next.next.states.getFirstState() instanceof Ready) {
                        return NOT_COMPLETED_CALCULATION;
                    }
                    beforeBowl = beforeBowl.bowl(next.next.states.getFirstState().countOfPins);
                }
            } else {
                if (next.states.getSecondState() instanceof Ready) {
                    return NOT_COMPLETED_CALCULATION;
                }
                beforeBowl = beforeBowl.bowl(next.states.getSecondState().countOfPins);
            }
        }

        if (beforeBowl == null) {
            return next.getScore();
        }

        return beforeBowl.getScore();
    }

    State firstState() {
        return states.getFirstState();
    }

    State secondState() {
        return states.getSecondState();
    }
}
