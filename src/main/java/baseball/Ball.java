package baseball;

public class Ball {
    private final int position;
    private final int number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = number;
    }


    public BallStatus validateStatus(Ball ball) {
        if (isStrike(ball)) {
            return BallStatus.STRIKE;
        }
        if (isBall(ball)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    public boolean isStrike(Ball ball) {
        if (this.position == ball.position && this.number == ball.number) {
            return true;
        }
        return false;
    }

    public boolean isBall(Ball ball) {
        if (this.number == ball.number) {
            return true;
        }
        return false;
    }
}
