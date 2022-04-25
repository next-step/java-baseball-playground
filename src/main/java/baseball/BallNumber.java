package baseball;

import java.util.Objects;

public class BallNumber {
    public static final int MIN_NO = 0;
    public static final int MAX_NO = 9;

    private int no;

    public BallNumber(int no) {
        if (no < MIN_NO || no > MAX_NO) {
            throw new IllegalArgumentException("볼 숫자는 1부터 9사이로 입력해야 합니다.");
        }

        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public boolean matchBallNo(BallNumber ballNumber) {
        return this.no == ballNumber.no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return getNo() == that.getNo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNo());
    }
}
