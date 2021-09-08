package baseball;

import java.util.List;

public class PlayGround {
    Balls balls;
    private int strike;
    private int ball;

    public PlayGround(Balls balls) {
        this.balls = balls;
    }

    public void play(List<Ball> balls) {
        for(Ball ball : balls){
            BallStatus status = this.balls.play(ball);
            if(status == BallStatus.STRIKE){
                this.strike += 1;
            }
            if(status == BallStatus.BALL){
                this.ball += 1;
            }
        }
    }

    public void printResult(){
        String result = strikeResult();
        result += ballResult();
        System.out.println(result);
    }

    public String strikeResult() {
        if(strike > 0){
            return strike+"스트라이크";
        }
        return "";
    }
    public String ballResult() {
        if(ball > 0){
            return ball+"볼";
        }
        return "";
    }

    public Balls getBalls() {
        return balls;
    }

    public void setBalls(Balls balls) {
        this.balls = balls;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }
}
