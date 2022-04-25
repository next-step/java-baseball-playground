package baseball;

public enum BallStatus {
    NOTHING, BALL, STRIKE;

    /**
     * 메시지를 통해 상태를 확인
     */
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
