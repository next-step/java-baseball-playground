package domain.vo;

import java.util.Objects;

public class Position {

    private static final int MIN_POSITION = 1;
    private static final int MAX_POSITION = 3;

    private int value;

    private Position(final int value) {
        this.value = value;
    }

    public static Position from(final int value) {
        validate(value);
        return new Position(value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        final Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private static void validate(final int value) {
        if (value < MIN_POSITION || value > MAX_POSITION) {
            throw new IllegalArgumentException("1~3 사이의 위치를 입력해야 합니다");
        }
    }
}
