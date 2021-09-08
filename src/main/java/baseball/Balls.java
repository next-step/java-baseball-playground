package baseball;

import java.util.List;

public class Balls {
    List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public BallStatus play(Ball ball) {
        return balls.stream()
                .map(ball1 -> ball1.play(ball))
                .filter(status -> status!=BallStatus.NOTHING)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

}
