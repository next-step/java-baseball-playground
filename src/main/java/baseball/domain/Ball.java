package baseball.domain;

import java.util.Objects;

public class Ball {
    private int position;
    private BallNumber ballNumber;

    public Ball(int position, int number) {
        this.position = position;
        this.ballNumber = new BallNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position &&
                Objects.equals(ballNumber, ball.ballNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNumber);
    }

    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }

        if (ballNumber.equals(ball.ballNumber)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }
}
