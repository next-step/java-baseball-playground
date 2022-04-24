package baseball;

import java.util.Objects;

public class Ball {
    private int index;
    private int ballNo;

    public Ball(int index, int ballNo) {
        this.index = index;
        this.ballNo = ballNo;
    }
    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }

        if (this.matchBallNo(ball)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    private boolean matchBallNo(Ball ball) {
        return this.ballNo == ball.ballNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return index == ball.index && ballNo == ball.ballNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, ballNo);
    }
}
