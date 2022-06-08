package bowling.domain;

class NormalFrame extends Frame {
    NormalFrame() {
        this.firstState = new Ready();
        this.secondState = new Ready();
        this.next = null;
    }

    @Override
    public void delivery(int countOfPins) {
        if (firstState instanceof Ready) {
            firstState = firstState.bowl(countOfPins);
            return;
        }
        secondState = firstState.bowl(countOfPins);
    }

    @Override
    public boolean additionallyDeliverable() {
        return (firstState instanceof Ready || firstState instanceof FirstBowl || firstState instanceof Gutter) && secondState instanceof Ready;
    }

    @Override
    public int getScore() {
        if (firstState instanceof FirstBowl && secondState instanceof Ready) {
            return 0;
        }

        Score score = createScore();
        if (score.canCalculateScore()) {
            return score.getScore();
        }

        return calculateAdditionalScore(score); // FIXME next 가 되어있었으므로 추후 firstState, secondState 메서드화 또는 구조 변경시 고려 필요
    }

    Score createScore() {
        int score = getThisFrameScore();
        if (firstState instanceof Strike) {
            return new Score(score, 2);
        }

        if (secondState instanceof Spare) {
            return new Score(score, 1);
        }

        return new Score(score, 0);
    }

    private int getThisFrameScore() {
        return firstState.countOfPins + secondState.countOfPins;
    }

    private int calculateAdditionalScore(Score beforeScore) {
        // TODO beforeScore에 현재 Frame의 쓰러진 Pin을 추가해 점수를 구하는 로직 구현
        Score bowl = null;
        if (beforeScore.getLeft() == 1) {
            bowl = beforeScore.bowl(next.firstState.countOfPins);
        }

        return next.getScore() + bowl.getScore();
    }
}
