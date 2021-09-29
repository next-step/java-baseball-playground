package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private ArrayList<Ball> balls = new ArrayList<>();

    public Balls(List<Integer> com) {
        mapComBall(com);
    }

    private void mapComBall(List<Integer> com) {
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, com.get(i)));
        }
    }

    public PlayResult play(List<Integer> player) {
        Balls userBalls = new Balls(player);
        PlayResult result = new PlayResult();

        for (Ball comBalls : balls) {
            BallStatus ballStatus = userBalls.play(comBalls);
            result.report(ballStatus);
        }
        return result;
    }

    public BallStatus play(Ball ball) {
        return balls.stream().map(answer -> answer.play(ball))
                .filter(ballStatus -> ballStatus != BallStatus.NOTHING)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
