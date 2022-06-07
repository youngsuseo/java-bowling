package bowling.domain;

import bowling.exception.CannotCalculateException;

public class Score {
    private int score;
    private int left;

    public Score(int score, int left) {
        this.score = score;
        this.left = left;
    }

    public Score bowl(int countOfPins) {
        return new Score(score += countOfPins, left - 1);
    }

    public int getScore() {
        if (!canCalculateScore()) {
            throw new CannotCalculateException("점수를 계산 할 수 없습니다.");
        }
        return this.score;
    }

    public boolean canCalculateScore() {
        return left == 0;
    }
}