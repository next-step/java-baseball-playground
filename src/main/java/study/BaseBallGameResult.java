package study;

import java.util.Objects;

public class BaseBallGameResult {
    private final int strike;

    private final int ball;

    public BaseBallGameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseBallGameResult that = (BaseBallGameResult) o;
        return strike == that.strike && ball == that.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}
