package baseball.domain;

public class GameResult {
    private int strike;
    private int ball;

    public boolean isEnd() {
        return strike == 3;
    }

    public void addResult(BallStatus ballStatus) {
        if (ballStatus.isStrike()) {
            strike++;
        }

        if (ballStatus.isBall()) {
            ball++;
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
