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

    public static String value(int inputScore, boolean spare) { // TODO stream 고려?
        if (spare) {
            return SPARE.symbol;
        }

        if (inputScore == STRIKE_SCORE) {
            return STRIKE.symbol;
        }

        if (inputScore == GUTTER_SCORE) {
            return GUTTER.symbol;
        }

        return String.valueOf(inputScore);
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
        return STRIKE.symbol.equals(delivery.getDelivery());
    }

    public static boolean spare(Delivery delivery) {
        return SPARE.symbol.equals(delivery.getDelivery());
    }
}