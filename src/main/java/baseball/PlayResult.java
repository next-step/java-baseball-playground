package baseball;

public class PlayResult {

    private int strike = 0;

    private int ball = 0;

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void report(BallStatus status) {
        if (status.equals(BallStatus.STRIKE)) {
            this.strike += 1;
        }

        if (status.equals(BallStatus.BALL)) {
            this.ball += 1;
        }
    }

    public boolean isGameEnd() {
        return this.strike == 3;
    }

    @Override
    public String toString() {

        if (this.ball > 0 && this.strike > 0) {
            return ball + "볼 " + strike +  "스트라이크";
        }

        if (this.ball > 0) {
            return ball + "볼";
        }

        if (this.strike > 0) {
            return strike + "스트라이크";
        }

        return "낫싱";
    }
}
