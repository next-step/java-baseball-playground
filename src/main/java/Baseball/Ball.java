package Baseball;

public class Ball {

    private final BallPosition ballPos;
    private final BallNumber ballNo;

    public Ball(int ballPos, int ballNo) {
        this.ballPos = new BallPosition(ballPos);//3자리수 보장됨.
        this.ballNo = new BallNumber(ballNo);//1이상 9이하의 값이 보장됨.
    }

    public BallStatus play(Ball ball) {
        if(ball == null) {
            throw new IllegalArgumentException("볼이 들어 오지 않았습니다.");
        }
        if(this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if(ball.getBallNo().equals(ballNo)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    public BallNumber getBallNo() {
        return ballNo;
    }

    public BallPosition getBallPos() {
        return ballPos;
    }

    @Override
    public boolean equals(Object ball) {
        if(ball instanceof Ball &&
            ((Ball) ball).getBallPos().equals(ballPos)
                && ((Ball) ball).getBallNo().equals(ballNo)) {
            return true;
        }
        return false;
    }
}
