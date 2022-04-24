package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private List<Ball> answers;

    public Balls(List<Integer> balls) {
        List<Ball> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            result.add(new Ball(i + 1, balls.get(i)));
        }
        this.answers = result;
    }

    public PlayResult play(List<Integer> balls) {
        Balls userBalls = new Balls(balls);
        PlayResult playResult = new PlayResult();
        for (Ball answer : answers) {
            BallStatus ballStatus = userBalls.play(answer);
            playResult.report(ballStatus);
        }

        return playResult;
    }

    public BallStatus play(Ball ball) {
        return this.answers.stream()
                    .map(answer -> answer.play(ball))
                    .filter(BallStatus::isNotNothing)
                    .findFirst()
                    .orElse(BallStatus.NOTHING);
    }
}
