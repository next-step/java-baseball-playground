package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> results;
    public Balls(List<Integer> numbers) {
        this.results = mapBall(numbers);
    }

    private List<Ball> mapBall(List<Integer> numbers){
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Ball ball = new Ball(i+1, numbers.get(i));
            balls.add(ball);
        }
        return balls;
    }

    public BallStatus compare(Ball ball) {
        return results.stream()
                .map(result -> result.play(ball))
                .filter(status -> status != BallStatus.NOTHING)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public BaseBallResult play(Balls userBalls) {
        BaseBallResult result = new BaseBallResult();
        for (int i = 0; i < 3; i++) {
            BallStatus status = userBalls.compare(this.results.get(i));
            result.add(status);
        }
        return result;
    }
}
