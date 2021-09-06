package baseball.domain;

import baseball.domain.vo.BallNumber;
import baseball.domain.vo.Position;

import java.util.Objects;

public class Ball {

    private final BallNumber number;
    private final Position position;

    public Ball(final BallNumber number, final Position position) {
        this.number = number;
        this.position = position;
    }

    public static Ball of(final int number, final int position) {
        BallNumber ballNumber = BallNumber.from(number);
        Position ballPosition = Position.from(position);
        return new Ball(ballNumber, ballPosition);
    }

    public BallStatus compare(final Ball other) {
        if (this.equals(other)) {
            return BallStatus.STRIKE;
        }

        if (other.hasSameNumber(number)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    private boolean hasSameNumber(final BallNumber number) {
        return this.number.equals(number);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        final Ball ball = (Ball) o;
        return number.equals(ball.number) && position.equals(ball.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
