package study.baseballfortdd;

import java.util.Objects;

public class BallNumber {
    private int ballNumber;

    public BallNumber(int ballNumber) {
        if(ballNumber < 1 || ballNumber > 9){
            System.out.println("test");
            throw new IllegalArgumentException("1 ~ 9까지 자연수를 입력하세요");
        }
        this.ballNumber = ballNumber;
    }

    public int getBallNumber() {
        return ballNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BallNumber)) return false;
        BallNumber that = (BallNumber) o;
        return ballNumber == that.ballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber);
    }
}
