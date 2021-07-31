package mybaseball;

public class Ball {
    private int position;
    private CheckBallNo ballNo;

    public Ball (int position, int ballNo) {
        this.ballNo = new CheckBallNo(ballNo);
        this. position = position;
    }

    public int getBallNo() {
        return this.ballNo.getBallNo();
    }

    public BallStatus Play(Ball ball) {
        return resultBallStatus(ball);
    }

    private BallStatus resultBallStatus(Ball ball) {

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
