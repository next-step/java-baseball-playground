package baseball;

public class BallCalculator {
    public BallStatus calculate(Ball ball, Balls ansBalls) {
        for (Ball ansBall : ansBalls.getBalls()) {
            if (ansBall.getNumber().equals(ball.getNumber())) {
                if (ansBall.getIdx().equals(ball.getIdx())) {
                    return BallStatus.STRIKE;
                }
                return BallStatus.BALL;
            }
        }
        return BallStatus.NOTHING;
    }

    public int[] calculate(Balls balls, Balls ansBalls) {
        int[] result = new int[2];
        for (Ball ball : balls.getBalls()) {
            BallStatus status = calculate(ball, ansBalls);
            if (status == BallStatus.STRIKE) {
                result[0]++;
            } else if (status == BallStatus.BALL) {
                result[1]++;
            }
        }
        return result;
    }
}
