package baseball;

import java.util.Objects;

public class Ball {
    private int index;
    private int ballNo;

    /**
     * 문제를 한 번에 해결하려고 하기보다는 가장 작은 단위로 쪼개서 구현하자.
     */
    public Ball(int index, int ballNo) {
        this.index = index;
        this.ballNo = ballNo;
    }

    /**
     * 객체 필드를 사용해서 상태 확인을 하지 말고,
     * 객체지향스럽게 객체에게 메시지를 보내서 상태를 확인하자.
     */
    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }

        if (this.matchBallNo(ball)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    private boolean matchBallNo(Ball ball) {
        return this.ballNo == ball.ballNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return index == ball.index && ballNo == ball.ballNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, ballNo);
    }
}
