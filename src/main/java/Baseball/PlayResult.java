package Baseball;

public class PlayResult {
    private Count strikeCount;
    private Count ballCount;

    public PlayResult() {
        strikeCount = new Count();
        ballCount = new Count();
    }

    public int getStrikeCount() {
        return strikeCount.getCount();
    }

    public int getBallCount() {
        return ballCount.getCount();
    }

    public void report(BallStatus ballStatus) {
        if(ballStatus.isStrike()) {
            strikeCount.count();
            return;
        }

        if(ballStatus.isBall()) {
            ballCount.count();
        }
    }

    public boolean isGameEnd() {
        return strikeCount.getCount() == 3;
    }
}
