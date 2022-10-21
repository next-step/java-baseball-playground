package baseball;

public class Ball {

    private final int ballNumber;
    private final int position;

    public Ball(int ballNumber, int position) {
        this.ballNumber = ballNumber;
        this.position = position;
    }

    public BallStatus compare(Ball ball) {
        if (this.equals(ball)) return BallStatus.STRIKE;
        if (this.matchesNumber(ball)) return BallStatus.BALL;
        return BallStatus.NOTHING;
    }

    private boolean matchesNumber(Ball ball) {
        return this.ballNumber == ball.ballNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return ballNumber == ball.ballNumber && position == ball.position;
    }
}
