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

    public BallStatus play(Ball ball) {
        return this.answers.stream()
                    .map(answer -> answer.play(ball))
                    .filter(BallStatus::isNotNothing)
                    .findFirst()
                    .orElse(BallStatus.NOTHING);
    }
}
