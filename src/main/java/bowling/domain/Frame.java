package bowling.domain;

import bowling.exception.InvalidDeliveryScoreException;

public abstract class Frame {
    private static final int MAXIMUM_SCORE = 10;

    Delivery firstDelivery;
    Delivery secondDelivery;

    public abstract void delivery(int inputScore);

    boolean firstDeliveryScore(int inputScore) {
        if (firstDelivery == null) {
            firstDelivery = new Delivery(Symbol.value(inputScore, false));
            return true;
        }
        return false;
    }

    boolean secondDeliveryScore(int inputScore) {
        if (secondDelivery == null) {
            secondDelivery = new Delivery(Symbol.value(inputScore, spare(inputScore)));
            return true;
        }
        return false;
    }

    abstract boolean spare(int inputScore);

    boolean spareDelivery(int inputScore, Delivery delivery) {
        int totalScore = Integer.parseInt(Symbol.value(delivery.getDelivery())) + inputScore;
        if (totalScore > MAXIMUM_SCORE) {
            throw new InvalidDeliveryScoreException("각 프레임 점수의 합 10을 넘을 수 없습니다.");
        }
        return totalScore == MAXIMUM_SCORE;
    }

    public abstract boolean additionallyDeliverable();

    public String getFirstDelivery() {
        if (firstDelivery == null) {
            return null;
        }
        return firstDelivery.getDelivery();
    }

    public String getSecondDelivery() {
        if (secondDelivery == null) { // TODO 이렇게 비교해야 하는지?
            return null;
        }
        return secondDelivery.getDelivery();
    }
}
