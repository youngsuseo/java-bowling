package bowling.domain;

public enum stateEnum {
    STATE("State"),
    READY("Ready"),
    FIRST_BOWL("FirstBowl"),
    STRIKE("Strike"),
    SPARE("Spare"),
    MISS("Miss"),
    GUTTER("Miss");

    private String state;

    stateEnum(String state) {
        this.state = state;
    }

    
}