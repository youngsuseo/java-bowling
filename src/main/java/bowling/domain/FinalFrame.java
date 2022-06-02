package bowling.domain;

public class FinalFrame extends NormalFrame {
    private Delivery bonusDelivery;

    @Override
    public void delivery(int inputScore) {
        if (firstDeliveryScore(inputScore)) {
            return;
        }

        if (secondDeliveryScore(inputScore)) {
            return;
        }

        bonusDelivery = new Delivery(Symbol.value(inputScore, spare(inputScore)));
    }


    @Override
    boolean spare(int inputScore) {
        if (firstDelivery == null) { // TODO 없어도 되는 로직이지만 가독성을 위해 추가??
            return false;
        }

        if (secondDelivery == null) {
            if (Symbol.strike(firstDelivery)) {
                return false;
            }
            return spareDelivery(inputScore, firstDelivery);
        }

        if (bonusDelivery == null) { // TODO 없어도 되는 로직이지만 가독성을 위해 추가??
            if (Symbol.spare(secondDelivery)) {
                return false;
            }
            return spareDelivery(inputScore, secondDelivery);
        }
        return false;
    }

    @Override
    public boolean additionallyDeliverable() {
        return bonusDelivery == null
                && (Symbol.strike(super.firstDelivery) || Symbol.spare(super.secondDelivery) || super.secondDelivery == null);
    }

    public String getBonusDelivery() {
        if (bonusDelivery == null) {
            return null;
        }
        return bonusDelivery.getDelivery();
    }
}
