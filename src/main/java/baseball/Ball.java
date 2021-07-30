package baseball;

public class Ball {
    private final int position;
    private final BallNumber ballNo;

    public Ball(int position, int ballNo) {
        this.position = position;
        this.ballNo = new BallNumber(ballNo);
    }

    public BallStatus play(Ball ball) {
        if(this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if(ball.matchBallNo(ballNo.getNo())) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean matchBallNo(int ballNo) {
        return this.ballNo.getNo() == ballNo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        return false;
    }
}
