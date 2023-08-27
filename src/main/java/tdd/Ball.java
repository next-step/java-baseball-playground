package tdd;

import java.util.Objects;

public class Ball {
    private final int location;
    private final int value;

    public Ball(int location, int value) {
        this.location = location;
        this.value = value;
    }

    public BallStatus play(Ball userBall) {
        if (this.equals(userBall)) {
            return BallStatus.STRIKE;
        }
        if (isBall(userBall)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean isBall(Ball userBall) {
        return this.value == userBall.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return location == ball.location && value == ball.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, value);
    }
}
