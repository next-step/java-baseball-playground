package baseball.domain.vo;

import java.util.Objects;

public class BallNumber {

    private static final int MIN_BALL_NUMBER = 1;
    private static final int MAX_BALL_NUMBER = 9;

    private int number;

    private BallNumber(final int number) {
        this.number = number;
    }

    public static BallNumber from(final int number) {
        validate(number);
        return new BallNumber(number);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof BallNumber)) return false;
        final BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    private static void validate(final int number) {
        if (number < MIN_BALL_NUMBER || number > MAX_BALL_NUMBER) {
            throw new IllegalArgumentException("1~9 사이의 숫자를 입력해야 합니다");
        }
    }
}
