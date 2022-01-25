package baseball;

public class Ball {
    private final int position;
    private final int ballNo;

    public Ball(int position, int ballNo) {
        this.position = position;
        this.ballNo = ballNo;
    }

    public BallUser play(Ball ball) {
        if(ball.matchBallNo(ballNo)){
            return BallUser.BAll;
        }
        return BallUser.NOTHING;
    }

    private boolean matchBallNo(int ballNo) {
        return this.ballNo == ballNo;
    }
}
