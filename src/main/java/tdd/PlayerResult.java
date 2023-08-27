package tdd;

public class PlayerResult {
    private int strikeCount = 0;
    private int ballCount = 0;

    public int getBall() {
        return ballCount;
    }

    public int getStrike(){
        return strikeCount;
    }

    public void report(BallStatus result) {
        if (result.isBall()) ballCount += 1;
        if (result.isStrike()) strikeCount += 1;
    }
}
