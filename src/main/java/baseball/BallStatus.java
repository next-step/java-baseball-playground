package baseball;

public enum BallStatus {
    NOTHING, BALL, STRIKE;

    public boolean isNotNothing() {
         return this != BallStatus.NOTHING;
    }
}
