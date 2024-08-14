package baseball;

public class Score {
    private int strike = 0;
    private int ball = 0;


    public int getStrike() {
        return this.strike;
    }
    public int getBall() {
        return this.ball;
    }

    public void report(BallStatus status) {
        if(status.isBall()) this.ball += 1;
        if(status.isStrike()) this.strike += 1;

    }
    public boolean isGameEnd() {
        return strike == 3;
    }
    public boolean isNothing() {
        return this.strike == 0 && this.ball == 0;
    }
}
