package study.numberBaseballGame;

public class Score {

    private int strike;
    private int ball;
    private int out;

    public void init() {
        strike = 0;
        ball = 0;
        out = 0;
    }

    public void update(int strikeCount, int ballCount, int outCount) {
        this.strike = strikeCount;
        this.ball = ballCount;
        this.out = outCount;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getOut() {
        return out;
    }
}
