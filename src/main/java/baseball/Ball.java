package baseball;

public class Ball {
    private final int location;
    private final int value;

    public Ball(int location, int value) {
        this.location = location;
        this.value = value;
    }

    public PitchStatus getResult(Ball ball) {
        if (this.equals(ball)) {
            return PitchStatus.STRIKE;
        }
        if (isBall(ball)) {
            return PitchStatus.BALL;
        }
        return PitchStatus.NOTHING;
    }

    private boolean isBall(Ball ball) {
        return this.location != ball.getLocation() &&
                this.value == ball.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return location == ball.location && value == ball.value;
    }

    public int getLocation() {
        return location;
    }

    public int getValue() {
        return value;
    }
}
