package bowling.domain;

import bowling.exception.PinOutOfSizeException;

import java.util.Objects;

public class Frame {

    private int tryCount;
    private int pins;

    public Frame(int tryCount, int pins) {
        this.tryCount = tryCount;
        this.pins = pins;
    }

    public void bowl(int pins) {
        this.pins += pins;
        if (this.pins > 10) {
            throw new PinOutOfSizeException("10개 이상의 핀을 쓰러뜨릴 수 없습니다.");
        }
        this.tryCount++;
    }

    public int tryCount() {
        return tryCount;
    }

    public boolean nextFrame() {
        return tryCount > 1;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Frame)) return false;
        final Frame frame = (Frame) o;
        return pins == frame.pins
                && tryCount == frame.tryCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pins, tryCount);
    }

    @Override
    public String toString() {
        return String.format("%d, %d", tryCount, pins);
    }
}
