package baseball;

public enum BallStatus {
    NOTHING, BALL, STRIKE;

    public boolean isNotNothing() {
         return this != BallStatus.NOTHING;
    }

    public boolean isStrike() {
        return this == BallStatus.STRIKE;
    }

    public boolean isBall() {
        return this == BallStatus.BALL;
    }
}
