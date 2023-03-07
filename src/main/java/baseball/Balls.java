package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> results = new ArrayList<>();
    public Balls(List<Integer> numbers) {
        mapBall(numbers);
    }

    private void mapBall(List<Integer> numbers){
        for (int i = 0; i < 3; i++) {
            Ball ball = new Ball(i+1, numbers.get(i));
            results.add(ball);
        }
    }

    public BallStatus compare(Ball ball) {
        return results.stream()
                .map(result -> result.play(ball))
                .filter(status -> status != BallStatus.NOTHING)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
