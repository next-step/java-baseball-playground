package baseball2;

public class PlayResult2 {

    private int strikeCount;
    private int ballCount;

    public int getStrike() {
        return this.strikeCount;
    }

    public int getBall() {
        return this.ballCount;
    }

    public void report(BallStatus2 ballStatus2) {
        if (ballStatus2.isStrike()) {
            this.strikeCount += 1;
        }
        if (ballStatus2.isBall()) {
            this.ballCount += 1;
        }
    }
}
