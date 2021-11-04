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

    public String ballMessage() {
        return ball + "볼";
    }

    public String strikeMessage() {
        return strike + "스트라이크";
    }
}
