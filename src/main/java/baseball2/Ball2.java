package baseball2;

import static baseball2.BallStatus2.BALL;
import static baseball2.BallStatus2.NOTHING;
import static baseball2.BallStatus2.STRIKE;

import java.util.Objects;

public class Ball2 {

    private int position;
    private int ballNo;

    public Ball2(int position, int ballNo) {
        this.position = position;
        this.ballNo = ballNo;
    }

    public BallStatus2 play(Ball2 ball2) {
        if (this.equals(ball2)) {
            return STRIKE;
        }
        if (matchBallNo(ball2)) {
            return BALL;
        }
        return NOTHING;
    }

    private boolean matchBallNo(Ball2 ball2) {
        return this.ballNo == ball2.ballNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball2 ball2 = (Ball2) o;
        return position == ball2.position && ballNo == ball2.ballNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNo);
    }
}
