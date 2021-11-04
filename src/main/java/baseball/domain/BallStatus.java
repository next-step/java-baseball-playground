package baseball.domain;

public enum BallStatus {
    STRIKE, BALL, NOTHING;

    public static boolean isNotNothing(BallStatus ballStatus) {
        return ballStatus != NOTHING;
    }
}
