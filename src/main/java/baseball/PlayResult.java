package baseball;

public class PlayResult {
    private int strike;
    private int ball;

    public PlayResult() {
        this.strike = 0;
        this.ball = 0;
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void report(BallStatus status) {
        if (status.isStrike()) {
            this.strike += 1;
        }

        if (status.isBall()) {
            this.ball += 1;
        }
    }
}
