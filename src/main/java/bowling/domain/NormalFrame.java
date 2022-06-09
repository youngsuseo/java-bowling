package bowling.domain;

class NormalFrame extends Frame {
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
        if (states.getFirstState() instanceof FirstBowl && states.getSecondState() instanceof Ready) {
            return 0;
        }

        Score score = states.createScore();
        if (score.canCalculateScore()) {
            return score.getScore();
        }

        return calculateAdditionalScore(score); // FIXME next 가 되어있었으므로 추후 firstState, secondState 메서드화 또는 구조 변경시 고려 필요
    }


    private int calculateAdditionalScore(Score beforeScore) {
        // TODO beforeScore에 현재 Frame의 쓰러진 Pin을 추가해 점수를 구하는 로직 구현
        Score beforeBowl = null;
        if (next.states.getFirstState() instanceof Ready) {
            return 0;
        }

        if (beforeScore.getLeft() == 1) {
            beforeBowl = beforeScore.bowl(next.states.getFirstState().countOfPins);
        }

        if (beforeScore.getLeft() == 2) {
            beforeBowl = beforeScore.bowl(next.states.getFirstState().countOfPins);
            if (next.states.getSecondState() instanceof Ready) {

                if (next.next == null) {
                    if (next.states.getSecondState() instanceof Ready) {
                        return 0;
                    }
                    beforeBowl = beforeBowl.bowl(next.states.getSecondState().countOfPins);
                } else {
                    if (next.next.states.getFirstState() instanceof Ready) {
                        return 0;
                    }
                    beforeBowl = beforeBowl.bowl(next.next.states.getFirstState().countOfPins);
                }
            } else {
                if (next.states.getSecondState() instanceof Ready) {
                    return 0;
                }
                beforeBowl = beforeBowl.bowl(next.states.getSecondState().countOfPins);
            }
        }

        if (beforeBowl == null) {
            return next.getScore();
        }

        return beforeBowl.getScore();
    }
}
