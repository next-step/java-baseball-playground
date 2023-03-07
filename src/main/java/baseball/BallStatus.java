package baseball;

public enum BallStatus {
    BALL, NOTHING, STRIKE;

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
