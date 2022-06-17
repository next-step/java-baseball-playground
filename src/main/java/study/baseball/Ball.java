package study.baseball;

import java.util.Objects;

public class Ball {

    private final Integer number;
    private final Integer position;


    public Ball(Integer number, Integer position) {
        this.number = number;
        this.position = position;
    }

    public boolean isStrike(Ball ball) {
        return this.equals(ball);
    }

    public boolean isBall(Ball ball) {
        return this.number.equals(ball.number) && !this.position.equals(ball.position);
    }

    public boolean isFourBalls(Ball ball) {
        return !this.number.equals(ball.number) && !this.position.equals(ball.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Objects.equals(number, ball.number) && Objects.equals(position, ball.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }

    @Override
    public String toString() {
        return "number=" + number + ", position=" + position;
    }
}
