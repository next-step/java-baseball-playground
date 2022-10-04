package baseballgame.domain;

import java.util.Objects;

public class Ball {

    private final int position;
    private final int number;

    public Ball(int position, int number) {
        BallValidator.isValid(number);
        this.number = number;
        this.position = position;
    }

    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if (ball.matches(number)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean matches(int number) {
        return this.number == number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "position=" + position +
                ", number=" + number +
                '}';
    }
}
