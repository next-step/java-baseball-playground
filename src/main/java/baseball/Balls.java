package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> results;
    private final int MAX_SIZE = 3;
    public Balls(List<Integer> numbers) {
        checkSize(numbers);
        this.results = mapBall(numbers);
    }

    private void checkSize(List<Integer> numbers){
        if(numbers.size() > MAX_SIZE){
            throw new IllegalArgumentException("볼 사이즈가 올바르지 않습니다");
        }
    }

    private List<Ball> mapBall(List<Integer> numbers){
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < MAX_SIZE; i++) {
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
        for (int i = 0; i < MAX_SIZE; i++) {
            BallStatus status = userBalls.compare(this.results.get(i));
            result.add(status);
        }
        return result;
    }
}
