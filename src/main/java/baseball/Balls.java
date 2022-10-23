package baseball;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Balls {
    private static final int DIGIT_COUNT = 3;
    private final List<Ball> balls;

    public Balls(List<Integer> numbers) {
        balls = mapToBall(numbers);
    }

    private List<Ball> mapToBall(List<Integer> numbers) {
        if (numbers == null)
            return null;

        AtomicInteger i = new AtomicInteger();

        return numbers.stream()
                .map(e -> new Ball(e, i.getAndIncrement()))
                .collect(Collectors.toList());
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
