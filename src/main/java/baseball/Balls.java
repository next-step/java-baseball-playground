package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private List<Ball> answers; // 1,2,3

    public Balls(List<Integer> answers) {
        this.answers = mapBalls(answers);
    }

    public BallStatus play(Ball userBall) {
        return answers.stream()
                .map(answer -> answer.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public PlayResult play(List<Integer> balls) {
        PlayResult result = new PlayResult();

        Balls userBalls = new Balls(balls);

        return result;
    }

    private static List<Ball> mapBalls(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < answers.size(); i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }
        return balls;
    }
}
