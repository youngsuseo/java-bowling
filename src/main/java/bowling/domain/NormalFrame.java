package bowling.domain;

class NormalFrame extends Frame {

    public void delivery(int inputScore) {
        if (firstDeliveryScore(inputScore)) {
            return;
        }
        secondDeliveryScore(inputScore);
    }

    boolean spare(int inputScore) {
        return spareDelivery(inputScore, firstDelivery);
    }

    public boolean additionallyDeliverable() {
        return !Symbol.strike(firstDelivery) && secondDelivery == null;
    }
}
