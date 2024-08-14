package baseball;

public class Ball {
    // Step 1

    private final int position;
    private final int ballNum;

    public Ball(int position, int ballNum) {
        this.position = position;
        this.ballNum = ballNum;
    }


    public BallStatus playBall(Ball ball) {
        if(this.equals(ball)) return BallStatus.STRIKE;
        if(matchBallNum(ball.ballNum)) return BallStatus.BALL;
        return BallStatus.NOTHING;
    }

    private boolean matchBallNum(int ballNum) {
        return this.ballNum == ballNum;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)return true;
        if(o == null || this.getClass() != o.getClass()) return false; // 실행 중인 클래스 객체의 정보를 확인
        Ball ball = (Ball) o;
        return position == ball.position &&
                ballNum == ball.ballNum;
    }


}
