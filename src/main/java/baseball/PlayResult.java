package baseball;

public class PlayResult {
    private int strike = 0;
    private int ball = 0;

    public PlayResult() {}

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void report(BallStatus status) {
        if (status.isStrike()) {
            this.strike += 1;
        }

        if (status.isBall()) {
            this.ball += 1;
        }
    }

    public boolean isGameEnd() {
        return strike == Balls.BALL_SIZE;
    }
}
