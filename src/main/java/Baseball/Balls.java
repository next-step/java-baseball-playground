package Baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private List<Ball> balls;
    public Balls(List<Integer> balls) {
        this.balls = new ArrayList<>();
        for(int i = 0; i < balls.size(); i++) {
            this.balls.add(new Ball(i + 1, balls.get(i)));
        }
    }

    public PlayResult play(List<Integer> userBallNo) {
        Balls userBalls = new Balls(userBallNo);
        PlayResult playResult = new PlayResult();
        for (Ball ball : balls) {
            BallStatus ballStatus = userBalls.play(ball);
            playResult.report(ballStatus);
        }
        return playResult;
    }

    public BallStatus play(Ball userBall) {
        return balls.stream()
                .map(balls -> balls.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
