package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private static final int DIGIT_COUNT = 3;
    private final List<Ball> balls;

    public Balls(List<Integer> numbers) {
        balls = mapToBall(numbers);
    }

    private List<Ball> mapToBall(List<Integer> numbers) {
        List<Ball> mappedBalls = new ArrayList<>();

        for (int i = 0; i < DIGIT_COUNT; i++) {
            mappedBalls.add(new Ball(numbers.get(i), i + 1));
        }

        return mappedBalls;
    }

    private BallStatus compare(Ball ball) {
        return balls.stream()
                .map(computerBall -> computerBall.compare(ball))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public PlayResult play(List<Integer> numbers) {
        PlayResult result = new PlayResult();
        List<Ball> inputBalls = mapToBall(numbers);

        for (Ball ball : inputBalls) {
            BallStatus status = this.compare(ball);
            result.report(status);
        }

        return result;
    }
}
