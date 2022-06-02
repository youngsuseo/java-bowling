package bowling.domain;

import bowling.exception.InvalidDeliveryScoreException;

public class Delivery {
    private static final String NUMBER_REGEX = "\\d+";
    private static final int MAXIMUM_SCORE = 10;

    private final String delivery;

    public Delivery(String delivery) {
        if (delivery.matches(NUMBER_REGEX) && Integer.parseInt(delivery) > MAXIMUM_SCORE) {
            throw new InvalidDeliveryScoreException("입력한 숫자는 " + MAXIMUM_SCORE + "을 넘을 수 없습니다.");
        }

        this.delivery = delivery;
    }

    public String getDelivery() {
        return delivery;
    }
}