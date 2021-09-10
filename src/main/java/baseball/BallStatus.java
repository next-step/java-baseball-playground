package baseball;

public enum BallStatus {
    STRIKE, BALL, NOTHING;

    public boolean isStrike(){
        return this == STRIKE;
    }
    public boolean isSNothing(){
        return this == NOTHING;
    }
    public boolean isBall(){
        return this == BALL;
    }
}
