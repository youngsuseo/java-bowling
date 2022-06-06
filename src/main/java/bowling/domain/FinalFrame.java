package bowling.domain;

public class FinalFrame extends NormalFrame {
    private State bonusState;

    public FinalFrame() {
        super();
        this.bonusState = new Ready();
    }

    @Override
    public void delivery(int countOfPins) {
        if (firstState instanceof Ready) {
            firstState = firstState.bowl(countOfPins);
            return;
        }

        if (firstState instanceof Strike && secondState instanceof Ready) {
            secondState = secondState.bowl(countOfPins);
            return;
        }

        if (secondState instanceof Ready) {
            secondState = firstState.bowl(countOfPins);
            return;
        }

        if (secondState instanceof Strike || secondState instanceof Spare) {
            bonusState = bonusState.bowl(countOfPins);
            return;
        }

        if (firstState instanceof Strike) {
            bonusState = secondState.bowl(countOfPins);
        }
    }

    @Override
    public boolean additionallyDeliverable() {
        return bonusState instanceof Ready
                && (firstState instanceof Strike || secondState instanceof Spare || secondState instanceof Ready);
    }

    @Override
    public int getScore() {
//        if (firstState instanceof Ready || secondState instanceof Ready) {
//            return 0;
//        }
//
//        int result = 0;
//        if (firstState instanceof Strike) {
//            Score score = new Score(firstState.countOfPins, 2);
//            Score bowl = score.bowl(secondState.countOfPins); // FIXME 값에 직접적으로 접근 하지 않도록
//            Score totalScore = bowl.bowl(bonusState.countOfPins);
//            result += totalScore.getScore();
//        } else {
//            result += firstState.countOfPins;
//        }
//
//        // bonus 점수가 없는경우
//
//        if (secondState instanceof Spare || secondState instanceof Strike) {
//            Score score = new Score(secondState.countOfPins, 1);
//            Score bowl = score.bowl(bonusState.countOfPins);
//            result += bowl.getScore();
//        } else {
//            result += secondState.countOfPins;
//        }
//
//        return result + bonusState.countOfPins;
        return firstState.countOfPins + secondState.countOfPins + bonusState.countOfPins;
    }

    public State getSecondState() {
        return secondState;
    }

    public State getBonusState() {
        return bonusState;
    }
}
