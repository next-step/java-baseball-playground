package study.baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> answers;
    
    public Balls(List<Integer> balls) {
        this.answers = mapBalls(balls);
    }

    private List<Ball> mapBalls(List<Integer> balls) {
        List<Ball> answerBalls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            answerBalls.add(new Ball(i + 1, balls.get(i)));
        }
        return answerBalls;
    }

    public BallStatus play(Ball ball) {
        return  answers.stream()
                       .map(answer -> answer.play(ball))
                       .filter(BallStatus::isNotNothing)
                       .findFirst()
                       .orElse(BallStatus.NOTHING);
    }
}
