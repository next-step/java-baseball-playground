package study.baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> balls;

    public Balls(List<Integer> answers) {
        this.balls = mapBalls(answers);
    }

    private static List<Ball> mapBalls(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i+1, answers.get(i)));
        }
        return balls;
    }

    public BallStatus play(Ball userBall) {
        return balls.stream()
                .map(answer -> answer.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
