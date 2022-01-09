package baseball;

import java.util.Objects;

public class Ball {

    private final int position;
    private final int ballNumber;

    public Ball(int position, int ballNo) {

        this.position=position;
        this.ballNumber=ballNo;
    }

    public BallStatus play(Ball ball){

        if(this.equals(ball)){
            return BallStatus.STRIKE;
        }
        if(ball.matchBallNo(ballNumber)){
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    public boolean matchBallNo(int ballNumber){
        return this.ballNumber==ballNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && ballNumber == ball.ballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNumber);
    }
}
