package baseball.domain;

import baseball.dto.RoundOutputDto;

import java.util.LinkedHashSet;
import java.util.Set;

public class Round {

    private static final int ENOUGH_STRIKE_INCLUSIVE = 3;
    private static final int BASEBALL_LENGTH = 3;

    private final Balls balls;

    private Round(final Balls balls) {
        this.balls = balls;
    }

    public static Round from(Balls balls) {
        return new Round(balls);
    }

    public static Round nextRound(final Generation generation) {
        Set<Integer> numbers = generateNumbers(generation);
        Balls balls = Balls.from(numbers);
        return new Round(balls);
    }

    private static Set<Integer> generateNumbers(final Generation generation) {
        Set<Integer> set = new LinkedHashSet<>();
        while (set.size() < BASEBALL_LENGTH) {
            int systemNumber = generation.generate();
            set.add(systemNumber);
        }
        return set;
    }

    public RoundOutputDto countResult(Balls userBalls) {
        BallStatuses ballStatuses = balls.compare(userBalls);
        int strike = ballStatuses.countStrike();
        int ball = ballStatuses.countBall();
        return RoundOutputDto.of(strike, ball);
    }

    public boolean hasEnough(final int strike) {
        return strike == ENOUGH_STRIKE_INCLUSIVE;
    }
}
