package baseball;

import java.util.Objects;

public class Ball {


    private final int position;
    private final BallNumber value;

    public Ball(int position, int value) {
        this.position = position;
        this.value = new BallNumber(value);
    }

    public BallStatus play(Ball ball) {
        if(this.equals(ball)){
            return BallStatus.STRIKE;
        }
        if(matchValue(ball)){
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    public boolean matchValue(Ball ball){
        return this.value == ball.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && value == ball.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, value);
    }
}
