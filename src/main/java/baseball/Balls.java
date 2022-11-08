package baseball;

import static baseball.BallStatus.BALL;
import static baseball.BallStatus.NOTHING;
import static baseball.BallStatus.STRIKE;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> answers;

    public Balls(List<Integer> answer) {
        this.answers = getBallEntity(answer);
    }

    private static List<Ball> getBallEntity(List<Integer> answer) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answer.get(i)));
        }
        return balls;
    }

    public PlayResult play(List<Integer> userBalls) {
        Balls balls = new Balls(userBalls);

        PlayResult playResult = new PlayResult();
        for (Ball answer : answers) {
            BallStatus ballStatus = balls.play(answer);
            playResult.report(ballStatus);
        }
        return playResult;
    }

    public BallStatus play(Ball ball) {
        return answers.stream()
            .map(answer -> answer.play(ball))
            .filter(ballStatus -> ballStatus.isNotNothing())
            .findFirst()
            .orElse(NOTHING);
    }


}
