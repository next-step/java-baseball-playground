package baseball.domain;

import baseball.dto.RoundOutputDto;

public class Round {
    public static final int ENOUGH_STRIKE_INCLUSIVE = 3;
    private Balls balls;
    private boolean isOver;

    public Round(final Balls balls, final boolean isOver) {
        this.balls = balls;
        this.isOver = isOver;
    }

    public static Round from(Balls balls) {
        return new Round(balls, false);
    }
    
    public RoundOutputDto countResult(Balls userBalls) {
        BallStatuses ballStatuses = balls.compare(userBalls);
        int strike = ballStatuses.countStrike();
        int ball = ballStatuses.countBall();
        areEnoughStrikes(strike);
        return RoundOutputDto.of(strike, ball);
    }

    private void areEnoughStrikes(final int strike) {
        if (strike == ENOUGH_STRIKE_INCLUSIVE) {
            isOver = true;
        }
    }

    public boolean isOver() {
        return isOver;
    }
}
