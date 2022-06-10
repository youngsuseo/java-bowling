package bowling.domain;

import bowling.exception.CannotCalculateException;

import java.util.Objects;

public class Score {
    private static final int NO_MORE_CALCULATION = 0;
    private static final int DEFAULT_VALUE = 0;

    private int score;
    private int left;

    Score() {
        this(DEFAULT_VALUE, DEFAULT_VALUE);
    }

    Score(int score, int left) {
        this.score = score;
        this.left = left;
    }

    public Score bowl(int countOfPins) {
        return new Score(score += countOfPins, left - 1);
    }

    int getScore() {
        if (!canCalculateScore()) {
            throw new CannotCalculateException("점수를 계산 할 수 없습니다.");
        }
        return this.score;
    }

    boolean canCalculateScore() {
        return left == NO_MORE_CALCULATION;
    }

    int getLeft() {
        return left;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Score score1 = (Score) o;
        return score == score1.score && left == score1.left;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, left);
    }
}