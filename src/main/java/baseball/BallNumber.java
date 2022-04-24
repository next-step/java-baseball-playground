package baseball;

import java.util.Objects;

public class BallNumber {
    private int no;

    public BallNumber(int ballNo) {
        this.no = ballNo;
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
