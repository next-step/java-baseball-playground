package baseball2;

import static baseball2.BallStatus2.*;

import java.util.ArrayList;
import java.util.List;

public class Balls2 {

    private List<Ball2> comBalls;

    public Balls2(List<Integer> answers) {
        this.comBalls = createBalls(answers);
    }

    // instance 변수에 의존하지 않기에 static ok
    private static List<Ball2> createBalls(List<Integer> answers) {
        List<Ball2> balls = new ArrayList<>();
        for (int i = 0; i < answers.size(); i++) {
            balls.add(new Ball2(i + 1, answers.get(i)));
        }

        return balls;
    }

    public PlayResult2 play(List<Integer> userBall) {
        Balls2 balls2 = new Balls2(userBall);

        PlayResult2 playResult2 = new PlayResult2();
        for (Ball2 comBall : comBalls) {
            BallStatus2 ballStatus2 = balls2.play(comBall);
            playResult2.report(ballStatus2);
        }

        return playResult2;
    }

    // (1,1) (2,2) (3,3)
    public BallStatus2 play(Ball2 userBall) {
        return comBalls.stream()
            .map(comBall -> comBall.play(userBall))
            .filter(ballStatus -> ballStatus != NOTHING)
            .findFirst()
            .orElse(NOTHING);
    }
}
