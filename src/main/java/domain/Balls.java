package domain;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Balls {

    public static final int START_POSITION = 1;
    public static final int MAX_POSITION = 3;

    private final List<Ball> values;

    private Balls(final List<Ball> values) {
        this.values = values;
    }

    public static Balls from(final List<Integer> numbers) {
        validate(numbers);
        List<Ball> balls = changeBallsFrom(numbers);
        return new Balls(balls);
    }

    private static List<Ball> changeBallsFrom(final List<Integer> numbers) {
        AtomicInteger position = new AtomicInteger(START_POSITION);

        return numbers.stream()
                .map(number -> Ball.of(number, position.getAndIncrement()))
                .collect(Collectors.toList());
    }

    private static void validate(List<Integer> numbers) {
        List<Integer> distinctNumber = extractDistinctNumber(numbers);

        if (distinctNumber.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 수가 존재합니다");
        }

        if (distinctNumber.size() != MAX_POSITION) {
            throw new IllegalArgumentException("길이가 3이어야 합니다");
        }
    }

    private static List<Integer> extractDistinctNumber(final List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public BallStatuses compare(final Balls other) {
        List<BallStatus> statuses = values.stream()
                .map(other::compareBallStatus)
                .collect(Collectors.toList());
        return BallStatuses.from(statuses);
    }

    public BallStatus compareBallStatus(final Ball other) {
        return values.stream()
                .map(ball -> ball.compare(other))
                .filter(ballStatus -> ballStatus.isStrike() || ballStatus.isBall())
                .findAny()
                .orElse(BallStatus.NOTHING);
    }
}
