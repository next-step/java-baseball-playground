package baseball;

import static baseball.BallStatus.NOTHING;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> balls;

    public Balls(List<Integer> answer) {
        this.balls = getBallEntity(answer);
    }

    private static List<Ball> getBallEntity(List<Integer> answer) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answer.get(i)));
        }
        return balls;
    }

    public BallStatus play(Ball ball) {
        return balls.stream()
            .map(answer -> answer.play(ball))
            .filter(ballStatus -> ballStatus.isNotNothing())
            .findFirst()
            .orElse(NOTHING);
    }


}
