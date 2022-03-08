package Baseball;

public class PlayResult {

    private int strikeCount = 0;
    private int ballCount = 0;

    public int getStrike() {
        return strikeCount;
    }

    public int getBall() {
        return ballCount;
    }

    public void report(BallStatus ballStatus) {
        if(ballStatus.isStrike()) {
            strikeCount++;
            return;
        }
        if(ballStatus.isBall()) {
            ballCount++;
            return;
        }
    }

    public boolean isGameEnd() {
        return strikeCount == 3;
    }
}
