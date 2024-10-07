package baseball;

import java.util.Objects;

public class Ball {

    private final int position, ballNo;

    public Ball(int position, int ballNo) {
        this.position = position;
        this.ballNo = ballNo;
    }

    public BallStatus play(Ball ball) {

        // 1,4 - 2,5 / nothing
        // 1,4 - 2,4 / ball
        // 1,4 - 1,4 / strike

        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }

        if (ball.matchBallNumber(ballNo)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    private boolean matchBallNumber(int ballNo) {
        return this.ballNo == ballNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return position == ball.position && ballNo == ball.ballNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNo);
    }
}
