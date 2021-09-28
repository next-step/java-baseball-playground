package baseball;

public class PlayResult {

    private int StrikeCount;
    private int ballCount;
    
    public int getStrikeCount() {
        return StrikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void report(BallStatus ballStatus) {

        if (isStrike(ballStatus)) {
            StrikeCount++;
            return;
        }
        if (isBall(ballStatus)) {
            ballCount++;
            return;
        }
    }

    private boolean isBall(BallStatus ballStatus) {
        return ballStatus == BallStatus.BALL;
    }

    private boolean isStrike(BallStatus ballStatus) {
        return ballStatus == BallStatus.STRIKE;
    }

    public boolean EndGame() {
        return this.StrikeCount==3;
    }
}
