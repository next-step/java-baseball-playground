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

    public Score play(List<Integer> userNumbers) {
        Score score = new Score();
        List<Ball> userBall = mapBalls(userNumbers);
        for (Ball ball : userBall) {
            score.add(this.play(ball));
        }
        return score;
    }

    public BallStatus play(Ball ball) {
        return  answers.stream()
                       .map(answer -> answer.play(ball))
                       .filter(BallStatus::isNotNothing)
                       .findFirst()
                       .orElse(BallStatus.NOTHING);
    }
}
