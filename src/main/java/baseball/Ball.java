package baseball;

import java.util.Objects;

public class Ball {


    private final int position;
    private final int no;

    public Ball(int position, int no) throws IllegalArgumentException {
        if (!ValidationUtils.ValidNo(no)) {
            throw new IllegalArgumentException("1 ~ 9 사이의 숫자를 입력하세요.");
        }

        this.position = position;
        this.no = no;
    }

    public BallStatus play(Ball ball) {

        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }

        if (this.isMatchNo(ball.no)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    private boolean isMatchNo(int no) {
        return this.no == no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && no == ball.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, no);
    }
}
