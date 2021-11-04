package baseball.domain;

import java.util.Objects;

public class BallNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private int number;

    public BallNumber(int number) {
        if (number > MAX_NUMBER || number < MIN_NUMBER) {
            throw new IllegalArgumentException("1 ~ 9 숫자를 입력하세요.");
        }

        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
