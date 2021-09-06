package baseball.domain;

import baseball.dto.RoundOutputDto;

public class Round {

    private static final int ENOUGH_STRIKE_INCLUSIVE = 3;

    private final Balls balls;

    public Round(final Balls balls) {
        this.balls = balls;
    }

    public static Round from(Balls balls) {
        return new Round(balls);
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
