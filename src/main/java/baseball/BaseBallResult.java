package baseball;

public class BaseBallResult {
    private int strikeCount = 0;
    private int ballCount = 0;

    public boolean isNotThing() {
        return strikeCount == 0 && ballCount == 0;
    }

    public void add(BallStatus status) {
        if( status.isStrike() ){
            strikeCount++;
            return;
        }
        if( status.isBall() ){
            ballCount++;
        }

    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isGameOver() {
        return strikeCount == 3;
    }
}
