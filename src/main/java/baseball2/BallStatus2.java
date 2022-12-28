package baseball2;

public enum BallStatus2 {

    STRIKE,
    BALL,
    NOTHING,
    ;

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
