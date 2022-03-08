package Baseball;

public class Ball {

    private final int position;
    private final BallNumber ballNo;

    public Ball(int position, int ballNo) {
        this.position = position;
        this.ballNo = new BallNumber(ballNo);//1이상 9이하의 값이 보장됨.
    }

    public BallStatus play(Ball ball) {
        if(ball != null && this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if(ball != null && ball.matchBallNo(ballNo)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean matchPosition(int position) {
        return this.position == position;
    }

    private boolean matchBallNo(int ballNo) {
        return this.ballNo == ballNo;
    }

    @Override
    public boolean equals(Object ball) {
        if(ball instanceof Ball &&
            ((Ball) ball).matchPosition(position) && ((Ball) ball).matchBallNo(ballNo)) {
            return true;
        }
        return false;
    }
}
