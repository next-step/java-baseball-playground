package Baseball;

public class Ball {
    private BallPosition ballPos;
    private BallNumber ballNo;

    public Ball(int ballPos, int ballNo) {
        this.ballPos = new BallPosition(ballPos);
        this.ballNo = new BallNumber(ballNo);
    }

    public int getBallPos() {
        return ballPos.getBallPos();
    }

    public int getBallNo() {
        return ballNo.getBallNumber();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Ball
                && ((Ball) obj).getBallPos() == this.getBallPos()
                && ((Ball) obj).getBallNo() == this.getBallNo()) {
            return true;
        }

        return false;
    }

    public BallStatus play(Ball ball) {
        if(ball == null) {
            throw new NullPointerException("볼이 비어있습니다.");
        }

        if(this.equals(ball)) {
            return BallStatus.STRIKE;
        }

        if (this.getBallNo() == ball.getBallNo()) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }
}
