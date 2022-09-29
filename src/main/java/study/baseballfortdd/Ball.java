package study.baseballfortdd;

import java.util.Objects;


public class Ball {
    private BallNumber ballNumber;
    // 포지션의 경우 굳이 포지션 객체를 따로 만들 필요가 있을까?
    // 이유는 입력을 받을 때 이미 자릿수는 걸러져야한다. 입력을 받을 때 따로 걸러야한다.
    private Integer position;
    public Ball(int ballNumber, int position) {
        this.ballNumber = new BallNumber(ballNumber);
        this.position = position;
    }

    public BallNumber getBallNumber() {
        return ballNumber;
    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return Objects.equals(ballNumber, ball.ballNumber) && Objects.equals(position, ball.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber, position);
    }

    public BallStatus is(Ball computerBall) {
        if(this.equals(computerBall)){
            return BallStatus.STRIKE;
        }

        if(!this.equals(computerBall)){
            if(this.ballNumber.equals(computerBall.ballNumber)) return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }
}
