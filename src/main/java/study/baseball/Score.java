package study.baseball;

public class Score {
    private Integer strike = 0;
    private Integer ball = 0;

    public int strike() {
        return this.strike;
    }

    public int ball() {
        return this.ball;
    }

    public void add(BallStatus ballStatus) {
        if (ballStatus.isStrike()) {
            this.strike += 1;
        }
        if (ballStatus.isBall()) {
            this.ball += 1;
        }
    }
}
