package bowling.domain;

public enum Symbol {
    STRIKE("X"),
    SPARE("/"),
    GUTTER("-");

    private String symbol;

    private static final int STRIKE_SCORE = 10;
    private static final int GUTTER_SCORE = 0;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public static State value(int inputScore, boolean spare) { // TODO stream 고려?
        if (spare) {
//            return new Spare();
        }

        if (inputScore == STRIKE_SCORE) {
            return new Strike();
        }

        if (inputScore == GUTTER_SCORE) {
            return new Gutter();
        }

        return null;
//        return new Miss();
    }

    public static String value(String symbol) {
        if (STRIKE.symbol.equals(symbol)) {
            return String.valueOf(STRIKE_SCORE);
        }

        if (GUTTER.symbol.equals(symbol)) {
            return String.valueOf(GUTTER_SCORE);
        }

        return symbol;
    }

    public static boolean strike(Delivery delivery) {
        return STRIKE.symbol.equals(delivery.getCountOfPins());
    }

    public static boolean spare(Delivery delivery) {
        return SPARE.symbol.equals(delivery.getCountOfPins());
    }
}