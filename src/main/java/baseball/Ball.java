package baseball;

public class Ball {
    private final int ballNum;
    private final int position;

    public Ball(int position, int ballNum) {
        this.position = position;
        this.ballNum = ballNum;
    }

    public BallStatus play(Ball ball) {
        BallStatus ballStatus = null;
        if(ball.mathBallNum(ballNum)){
            ballStatus =  BallStatus.BALL;
            if(ball.mathPosition(position)){
                ballStatus = BallStatus.STRIKE;
            }
        }
        else ballStatus = BallStatus.NOTING;

        return  ballStatus;
    }

    private boolean mathPosition(int position) {
        return  this.position == position;
    }

    private boolean mathBallNum(int ballNum) {
        return  this.ballNum == ballNum;
    }

}
