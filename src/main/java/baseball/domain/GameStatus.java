package baseball.domain;

public class GameStatus {
    private int ball;
    private int strike;

    public GameStatus(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean restartOrQuit(int button) {
        return button == 1;
    }
}
